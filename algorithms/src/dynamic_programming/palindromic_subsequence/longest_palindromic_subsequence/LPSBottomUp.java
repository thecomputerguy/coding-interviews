public class LPSBottomUp {
       
    public int findLPSLength(String input){
        if(input == null || input.length() == 0) return 0;
        
        int[][] dp = new int[input.length()][input.length()];
        //Loop for 1 length palindromic sequence
        for (int i = 0; i < input.length(); i++) {
            dp[i][i] = 1;
        }
        for (int start = input.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < input.length(); end++) {
                if(input.charAt(start) == input.charAt(end)){
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                }else{
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }

        return dp[0][input.length() - 1];
    }

    
    public static void main(String[] args) {
    LPSBottomUp lps = new LPSBottomUp();
    System.out.println(lps.findLPSLength("abdbca"));
    System.out.println(lps.findLPSLength("cddpd"));
    System.out.println(lps.findLPSLength("pqr"));
  }


}
