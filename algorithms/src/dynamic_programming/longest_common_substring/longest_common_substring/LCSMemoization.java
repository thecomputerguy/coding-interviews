public class LCSMemoization {

  public int findLCSLength(String s1, String s2) {
    if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
      return 0;
    }
    return findLCSLengthRecursive(s1, s2, 0, 0, 0, new Integer[s1.length()][s2.length()][Math.min(s1.length(), s2.length())]);
  }

  private int findLCSLengthRecursive(String s1, String s2, int index1, int index2, int count, Integer[][][] dp){
    if(index1 == s1.length() || index2 == s2.length()){
      return count;
    }

    if(dp[index1][index2][count] != null){
        return dp[index1][index2][count];
    }
    
    int c1 = count;
    if(s1.charAt(index1) == s2.charAt(index2)){
      c1 = findLCSLengthRecursive(s1, s2, index1 + 1, index2 + 1, count + 1, dp);
    }

    int c2 =  findLCSLengthRecursive(s1, s2, index1 + 1, index2, 0, dp);
    int c3 = findLCSLengthRecursive(s1, s2, index1, index2 + 1, 0, dp);

    dp[index1][index2][count] = Math.max(c1, Math.max(c2, c3));
    return dp[index1][index2][count];
  }

  public static void main(String[] args) {
    LCSMemoization lcs = new LCSMemoization();
    System.out.println(lcs.findLCSLength("abdca", "cbda"));
    System.out.println(lcs.findLCSLength("passport", "ppsspt"));
  }

}
