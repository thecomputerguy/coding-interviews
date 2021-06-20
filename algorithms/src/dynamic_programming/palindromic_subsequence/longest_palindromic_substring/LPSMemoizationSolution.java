public class LPSMemoizationSolution {
   
    public int findLPSLength(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        return findLPSLengthRecursive(input, 0, input.length() - 1, new Integer[input.length()][input.length()]);
    }

    private int findLPSLengthRecursive(String input, int start, int end, Integer[][] dp){
        if(start > end){
            return 0;
        }

        if(start == end){
            return 1;
        }

        if(dp[start][end] != null){
            return dp[start][end];
        }
        if(input.charAt(start) == input.charAt(end)){
            int remainingLength = end - start - 1;
            if(remainingLength == findLPSLengthRecursive(input, start + 1, end - 1, dp)){
                return 2 + remainingLength;
            }
        }

        int skipStart = findLPSLengthRecursive(input, start + 1, end, dp);
        int skipEnd = findLPSLengthRecursive(input, start, end - 1, dp);
        dp[start][end] = Math.max(skipStart, skipEnd);
        return dp[start][end];
    }
    
    public static void main(String[] args) {
        LPSMemoizationSolution lps = new LPSMemoizationSolution();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
  }
}
