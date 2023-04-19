public class CoinOutCmds {
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
