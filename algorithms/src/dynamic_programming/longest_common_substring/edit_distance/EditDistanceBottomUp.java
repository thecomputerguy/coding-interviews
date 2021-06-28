public class EditDistanceBottomUp {
        
  public int findMinOperations(String s1, String s2) {
    if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0){
        return 0;
    }

    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    
    //if s2 is empty, we can remove all the characters of s1 to make it empty too
    for (int i = 0; i < s1.length(); i++) {
        dp[i][0] = i;
    }

    //if s1 is empty then we have to insert all the characters from s2 in s1 to make them equal
    for (int i = 0; i < s2.length(); i++) {
        dp[0][i] = i;
    }
    
    for (int i = 1; i <= s1.length(); i++) {
        for (int j = 1; j <= s2.length(); j++) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            }else {
                int c1 = 1 + dp[i - 1][j]; // delete operation
                int c2 = 1 + dp[i - 1][j - 1]; // replace operation
                int c3 = 1 + dp[i][j - 1]; //insert operation
                dp[i][j] = Math.min(c1, Math.min(c2, c3));
            }
        }
    }
    return dp[s1.length()][s2.length()];
  }

  public static void main(String[] args) {
    EditDistanceBottomUp editDisatnce = new EditDistanceBottomUp();
    System.out.println(editDisatnce.findMinOperations("bat", "but"));
    System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
    System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
  }

}
