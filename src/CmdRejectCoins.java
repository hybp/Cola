public class CmdRejectCoins implements Command{
    @Override
    public String execute(VendingMachine v, String[] cmdParts) {
        if (v.getTotalCoin() == 0) {
            return "Rejected no coin!";
        }
        // 'changes' stores [how many coins] following the same order of coinUnits array
        // Since there are 4 currency units (fixed), use normal array
        return rejectCoins(v);
    }
    String rejectCoins(VendingMachine v) {
        String statement = "Rejected ";
        boolean firstOut = true;
        for (Integer coin : v.getInsertedCoins()) {
            if (firstOut) {
                statement += "$" + coin;
                firstOut = false;
            }
            else {
                statement += ", $" + coin;
            }
        }
        statement += String.format(". $%d in total.", v.getTotalCoin());
        v.clearCoins();
        return statement;
    }
}
