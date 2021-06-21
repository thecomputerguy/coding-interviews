public class MDSPBottomUp {
    
    public int findMinimumDeletions(String input){
        if(input== null || input.length() == 0){
            return 0;
        }
        return input.length() - findMinimumDeletionsDP(input);
    }

    private int findMinimumDeletionsDP(String input){
        int[][] dp = new int[input.length()][input.length()];
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
            MDSPBottomUp mdsp = new MDSPBottomUp();
            System.out.println(mdsp.findMinimumDeletions("abdbca"));
            System.out.println(mdsp.findMinimumDeletions("cddpd"));
            System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}
