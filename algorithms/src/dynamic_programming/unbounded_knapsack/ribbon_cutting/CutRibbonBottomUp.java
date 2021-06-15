public class CutRibbonBottomUp {

  public int countRibbonPieces(int[] ribbonLengths, int total) {
    if(ribbonLengths == null || ribbonLengths.length == 0 || total == 0){
      return 0;
    }

    int[][] dp = new int[ribbonLengths.length][total + 1];
    for (int i = 0; i < ribbonLengths.length; i++) {
        dp[i][0] = 0;
    }

    for (int i = 0; i < ribbonLengths.length; i++) {
        for (int j = 1; j <= total; j++) {
            if(i > 0){
                dp[i][j] = dp[i - 1][j];
            }
            
            if(ribbonLengths[i] <= j){
                dp[i][j] = Math.max(dp[i][j], dp[i][j - ribbonLengths[i]] + 1);
            }
        }
    }

    return dp[ribbonLengths.length - 1][total];
    
  }

  public static void main(String[] args) {
    CutRibbonMemoization cr = new CutRibbonMemoization();
    int[] ribbonLengths = {2,3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[]{2,3};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[]{3,5,7};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[]{3,5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }

}
