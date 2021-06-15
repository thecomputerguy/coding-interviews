public class CutRibbonMemoization {

  public int countRibbonPieces(int[] ribbonLengths, int total) {
    if(ribbonLengths == null || ribbonLengths.length == 0 || total == 0){
      return 0;
    }
    int result = countRibbonPiecesRecursive(ribbonLengths, total, 0, new Integer[ribbonLengths.length][total + 1]);
    return  result == Integer.MIN_VALUE ? -1 : result;
  }

  private int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int currentIndex, Integer[][] dp){
    if(currentIndex >= ribbonLengths.length){
      return Integer.MIN_VALUE;
    }

    if(total == 0){
      return 0;
    }

    if(dp[currentIndex][total] != null){
        return dp[currentIndex][total];
    }

    int count1 = Integer.MIN_VALUE;
    int count2 = Integer.MIN_VALUE;
    if(ribbonLengths[currentIndex] <= total){
      count1 = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex, dp);
      if(count1 != Integer.MIN_VALUE){
        count1 += 1;
      }
    }

    count2 = countRibbonPiecesRecursive(ribbonLengths, total, currentIndex + 1, dp);
    dp[currentIndex][total] = Math.max(count1, count2);
    return dp[currentIndex][total];
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
