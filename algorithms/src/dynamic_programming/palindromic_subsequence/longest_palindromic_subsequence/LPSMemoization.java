public class LPSMemoization {
       
    public int findLPSLength(String input){
        if(input == null || input.length() == 0) return 0;
        
        return findLPSLengthRecursive(input, 0, input.length() - 1, new Integer[input.length() + 1][input.length() + 1]);
    }

    private int findLPSLengthRecursive(String input, int startIndex, int endIndex, Integer[][] dp){
        if (startIndex > endIndex) {
            return 0;
        }

        if(startIndex == endIndex){
            return 1;
        }

        if(dp[startIndex][endIndex] != null){
            return dp[startIndex][endIndex];
        }

        if(input.charAt(startIndex) == input.charAt(endIndex)){
            dp[startIndex][endIndex] = 2 + findLPSLengthRecursive(input, startIndex + 1, endIndex - 1, dp);
            return dp[startIndex][endIndex];
        }

        int skipBeginning = findLPSLengthRecursive(input, startIndex + 1, endIndex, dp);
        int skipEnding = findLPSLengthRecursive(input, startIndex, endIndex - 1, dp);
        dp[startIndex][endIndex] = Math.max(skipBeginning, skipEnding);
        return dp[startIndex][endIndex];
    }
    
    public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }

}
