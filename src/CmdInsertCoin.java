public class CmdInsertCoin implements Command {
    @Override
    public String execute(VendingMachine v, String[] cmdParts) {
        Integer c = Integer.valueOf(cmdParts[1]);
        // Add the coin to Coin Slot
        v.insertCoin(c);
        // return a string "Inserted a $x coin. $y in total."
        return String.format("Inserted a $%d coin. $%d in total.",c, v.getTotalCoin());
        // x and y must be replaced by an appropriate value
    }
}
