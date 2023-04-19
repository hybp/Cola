public class CmdPurchase implements Command {
    @Override
    public String execute(VendingMachine v, String[] cmdParts) {
        // Get the product to be purchased
        String productName = cmdParts[1];
        Product product = v.getProduct(productName);

        // Get Vending Machine status
        int totalCoin = v.getTotalCoin();

        if (product.getQuantity() > 0 ) {
            if (totalCoin >= product.getPrice()){
                if (product.getQuantity()>0){
                    // If purchasable,
                    int totalChange = totalCoin - product.getPrice();
                    v.clearCoins();
                    v.dropProduct(product);
                    if (totalChange == 0) {
                        return String.format("Dropped %s. Paid $%d. No change.", productName, totalCoin);
                    }
                    return String.format("Dropped %s. Paid $%d. Your change: %s.", productName, totalCoin, rejectLetter(v.coinChanger(totalChange)));
                }
                else {
                    return String.format("%s is out of stock!",productName);
                }
            } else {
                return String.format("Not enough credit to buy %s! Inserted $%d but needs $%d.", productName, totalCoin, product.getPrice());
            }
        } else {
            return String.format("%s is out of stock!", productName);
        }
    }
    String rejectLetter(int[] changes) {
        String returnStatement = "";
        String[] strCoinUnits = {"$1","$2","$5","$10"};

        boolean firstOut = true;
        for (int i = 0; i < strCoinUnits.length; i++) {
            while (changes[i] != 0) {
                if(firstOut){
                    returnStatement += strCoinUnits[i];
                    firstOut = false;
                }
                else{
                    returnStatement += ", " + strCoinUnits[i];
                }
                changes[i]--;
            }
        }
        return returnStatement;
    }
}
