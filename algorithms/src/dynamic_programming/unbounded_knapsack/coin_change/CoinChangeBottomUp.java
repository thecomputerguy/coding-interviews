public class CoinChangeBottomUp {

  public int countChange(int[] denominations, int total) {
    if(denominations == null || denominations.length == 0 || total == 0){
        return 0;
    }
    
    int dp[][] = new int[denominations.length][total + 1];
    for (int i = 0; i < denominations.length; i++) {
        dp[i][0] = 1;
    }
    

    for (int i = 0; i < denominations.length; i++) {
        for (int t = 1; t <= total; t++) {
            
            if(i > 0){
                dp[i][t] = dp[i - 1][t];
            }

            if(denominations[i] <= t){
                dp[i][t] += dp[i][t - denominations[i]];
            }

        }
    }
     
    return dp[denominations.length - 1][total];
  }

  public static void main(String[] args) {
    CoinChangeBottomUp cc = new CoinChangeBottomUp();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }

}
