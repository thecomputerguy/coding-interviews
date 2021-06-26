public class SPMMemoization {
    
  public int findSPMCount(String str, String pat) {
    if(str == null || pat == null || str.length() == 0 || pat.length() == 0) return 0;
    return findSPMCountRecursive(str, pat, 0, 0, new Integer[pat.length()][str.length()]);
  }

  private int findSPMCountRecursive(String str, String pat, int strIndex, int patIndex, Integer[][] dp){
      if(patIndex == pat.length()){
        return 1; 
      }
      if(strIndex == str.length()){
        return 0;
      }

      if(dp[patIndex][strIndex] != null){
        return dp[patIndex][strIndex];
      }
      int c1 = 0;
      if(str.charAt(strIndex) == pat.charAt(patIndex)){
        c1 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex + 1, dp);
      }
      int c2 = findSPMCountRecursive(str, pat, strIndex + 1, patIndex, dp);

      dp[patIndex][strIndex] = c1 + c2;
      return dp[patIndex][strIndex];
  }

  public static void main(String[] args) {
    SPMMemoization spm = new SPMMemoization();
    System.out.println(spm.findSPMCount("baxmx", "ax"));
    System.out.println(spm.findSPMCount("tomorrow", "tor"));
  }

}
