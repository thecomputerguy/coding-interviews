public class LPSBottomUpSolution {
    
    public int findLPSLength(String input){
        if(input == null || input.length() == 0){
            return 0;
        }

        boolean[][] dp = new boolean[input.length()][input.length()];
        for (int i = 0; i < input.length(); i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        for (int start = input.length() - 1; start >= 0; start--) {
         for (int end = start + 1; end < input.length(); end++) {
             if(input.charAt(start) == input.charAt(end)){
                if(end - start == 1 || dp[start + 1][end - 1] == true){

                    dp[start][end] = true;
                    maxLength = Math.max(maxLength, end - start + 1);
                }
             }
         }   
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LPSBottomUpSolution lps = new LPSBottomUpSolution();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
  }
}
