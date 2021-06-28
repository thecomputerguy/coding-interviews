
public class SIBottomUp {
    
  public boolean findSI(String m, String n, String p) {
        if (m.length() + n.length() != p.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m.length() + 1][n.length() + 1];
        
        for (int i = 0; i <= m.length(); i++) {
            for (int j = 0; j <= n.length(); j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                }else if(i == 0 && n.charAt(j - 1) == p.charAt(j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }else if(j == 0 && m.charAt(i - 1) == p.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    if(i > 0 && m.charAt(i - 1) == p.charAt(i + j - 1)){
                        dp[i][j] = dp[i - 1][j];
                    }else if(j > 0 && n.charAt(j - 1) == p.charAt(i + j - 1)){
                        dp[i][j] |= dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m.length()][n.length()];
  }

  

  public static void main(String[] args) {
    SIBottomUp si = new SIBottomUp();
    System.out.println(si.findSI("abd", "cef", "abcdef"));
    System.out.println(si.findSI("abd", "cef", "adcbef"));
    System.out.println(si.findSI("abc", "def", "abdccf"));
    System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
  }

}
