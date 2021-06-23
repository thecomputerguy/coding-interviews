public class LCSBottomUp {

  public int findLCSLength(String s1, String s2) {
    if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
      return 0;
    }

    int[][] dp = new int[s1.length()][s2.length()];
    int maxLength = 0;
    for (int i = 1; i < s1.length(); i++) {
        for (int j = 1; j < s2.length(); j++) {
            if(s1.charAt(i) == s2.charAt(j)){
                dp[i][j] = 1 + dp[i - 1][j - 1];
                maxLength = Math.max(dp[i][j], maxLength);
            }            
        }        
    }
   
    return maxLength;
  }
  public static void main(String[] args) {
    LCSBottomUp lcs = new LCSBottomUp();
    System.out.println(lcs.findLCSLength("abdca", "cbda"));
    System.out.println(lcs.findLCSLength("passport", "ppsspt"));
  }
}
