public class EditDistanceMemoization {
        
  public int findMinOperations(String s1, String s2) {
    if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
        return 0;
    }
    return findMinOperationsRecursive(s1, s2, 0, 0, new Integer[s1.length()][s2.length()]);
  }

  private int findMinOperationsRecursive(String s1, String s2, int index1, int index2, Integer[][] dp) {
    if(index1 == s1.length()) return s2.length() - index2;
    if(index2 == s2.length()) return s1.length() - index1;
    if(dp[index1][index2] != null) return dp[index1][index2];
    if(s1.charAt(index1) == s2.charAt(index2)){
        return findMinOperationsRecursive(s1, s2, index1 + 1, index2 + 1, dp);
    }
    int c1 = 1 + findMinOperationsRecursive(s1, s2, index1 + 1, index2, dp);//delete operation
    int c2 = 1 + findMinOperationsRecursive(s1, s2, index1 + 1, index2 + 1, dp);//replace operation
    int c3 = 1 + findMinOperationsRecursive(s1, s2, index1, index2 + 1, dp);//insert operation

    dp[index1][index2] = Math.min(c1, Math.min(c2, c3));
    return dp[index1][index2];
  }

  public static void main(String[] args) {
    EditDistanceMemoization editDisatnce = new EditDistanceMemoization();
    System.out.println(editDisatnce.findMinOperations("bat", "but"));
    System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
    System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
  }

}
