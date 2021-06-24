public class MDIMemoization {

  public void findMDI(String s1, String s2) {
    
    int c1 = findMDI(s1, s2, 0, 0, new Integer[s1.length()][s2.length()]);
    System.out.println("Minimum deletions needed: " + (s1.length() - c1));
    System.out.println("Minimum insertions needed: " + (s2.length() - c1));
  }
  
  private int findMDI(String s1, String s2, int index1, int index2, Integer[][] dp){
    if(index1 == s1.length() || index2 == s2.length()){
        return 0;
    }

    if(dp[index1][index2] != null){
        return dp[index1][index2];
    }

    if(s1.charAt(index1) == s2.charAt(index2)){
        dp[index1][index2] = 1 + findMDI(s1, s2, index1 + 1, index2 + 1, dp);
        return dp[index1][index2];
    }

    int c1 = findMDI(s1, s2, index1 + 1, index2, dp);
    int c2 = findMDI(s1, s2, index1, index2 + 1, dp);
    dp[index1][index2] = Math.max(c1, c2);
    return dp[index1][index2];
}
 
  public static void main(String[] args) {
    MDIMemoization mdi = new MDIMemoization();
    mdi.findMDI("abc", "fbc");
    mdi.findMDI("abdca", "cbda");
    mdi.findMDI("passport", "ppsspt");
  }

}
