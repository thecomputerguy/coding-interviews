public class MinimumCoinChangeBottomUp {

  public int countChange(int[] denominations, int total) {
    if(denominations == null || denominations.length == 0 || total == 0){
        return 0;
    }
    int dp[][] = new int[denominations.length][total + 1];
    for (int i = 0; i < denominations.length; i++) {
        for (int j = 0; j <= total; j++) {
            dp[i][j] = Integer.MAX_VALUE;
        }
    }
    for (int i = 0; i < denominations.length; i++) {
        dp[i][0]  = 0;   
    }

    for (int i = 0; i < denominations.length; i++) {
        for (int j = 1; j <= total; j++) {
            if(i > 0){
                dp[i][j] =  dp[i-1][j];
            }
            if(denominations[i] <= j && dp[i][j - denominations[i]] != Integer.MAX_VALUE) {
               dp[i][j]  = Math.min(dp[i][j] ,dp[i][j - denominations[i]] + 1);
            }
        }
    }
    return  dp[denominations.length - 1][total] == Integer.MAX_VALUE ? -1 : dp[denominations.length - 1][total];
  }

  
  public static void main(String[] args) {
    MinimumCoinChangeBottomUp cc = new MinimumCoinChangeBottomUp();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    denominations = new int[]{3, 5};
    System.out.println(cc.countChange(denominations, 7));
  }

}
