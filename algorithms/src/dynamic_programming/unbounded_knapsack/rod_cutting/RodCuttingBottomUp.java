class RodCuttingBottomUp {

  public int solveRodCutting(int[] lengths, int[] prices, int n) {
    if(lengths == null || prices == null || prices.length == 0 || lengths.length == 0 || prices.length != lengths.length || n == 0){
        return 0;
    }
    int dp[][] = new int[lengths.length][n + 1];
    
    for (int i = 0; i < lengths.length; i++) {
        dp[i][0] = 0;
    }

    for (int i = 1; i <= n; i++) {
        if(lengths[0] == i) {
            dp[0][i] = prices[0];
        }       
    }

    for (int i = 1; i < lengths.length; i++) {
        for (int j = 1; j <= n; j++) {
            int profit1 = 0; int profit2 = 0;
            if(lengths[i] <= j) {
                profit1 = prices[i] + dp[i][j - lengths[i]];
            }
            profit2 = dp[i - 1][j];
            dp[i][j] = Math.max(profit1, profit2);
        }
    }


    return dp[prices.length - 1][n];
  }

  
  public static void main(String[] args) {
    RodCuttingBottomUp rc = new RodCuttingBottomUp();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }
}
