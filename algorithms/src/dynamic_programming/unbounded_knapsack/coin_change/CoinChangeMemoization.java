public class CoinChangeMemoization {

  public int countChange(int[] denominations, int total) {
    if(denominations == null || denominations.length == 0 || total == 0){
        return 0;
    }

    return countChangeRecursive(denominations, total, 0, new Integer[denominations.length][total + 1]);
  }

  private int countChangeRecursive(int[] denominations, int total, int currentIndex, Integer[][] dp){
      if(currentIndex >= denominations.length){
        return 0;
      }

      if(total == 0){
        return 1;
      }

      if(dp[currentIndex][total] != null){
        return dp[currentIndex][total];
      }

      int count1 = 0;
      int count2 = 0;
      if(denominations[currentIndex] <= total){
        count1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex, dp);
      }

      count2 = countChangeRecursive(denominations, total, currentIndex + 1, dp);

      dp[currentIndex][total] = count1 + count2;
      return dp[currentIndex][total];
  }
  
  public static void main(String[] args) {
    CoinChangeMemoization cc = new CoinChangeMemoization();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }
}


