public class SPMBottomUp {
    
    public int findSPMCount(String str, String pat) {
        if(str == null || pat == null) return 0;
        if(pat.length() == 0) return 1;
        if(str.length() == 0 || pat.length() > str.length()) return 0;
        
        int[][] dp = new int[str.length() + 1][pat.length() + 1];
        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {
                if(str.charAt(i-1) == pat.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[str.length()][pat.length()];
    }

    public static void main(String[] args) {
    SPMBottomUp spm = new SPMBottomUp();
    System.out.println(spm.findSPMCount("baxmx", "ax"));
    System.out.println(spm.findSPMCount("tomorrow", "tor"));
  }
}
