public class MinimumCoinChangeMemoization {

  public int countChange(int[] denominations, int total) {
    if(denominations == null || denominations.length == 0 || total == 0){
        return 0;
    }

    int result = countChange(denominations, total, 0, new Integer[denominations.length][total + 1]);
    return  result == Integer.MAX_VALUE ? -1 : result;
  }

  private int countChange(int[] denominations, int total, int currentIndex, Integer[][] dp){
      if(currentIndex >= denominations.length){
        return Integer.MAX_VALUE;
      }
      if(total == 0){
        return 0;
      }

      if(dp[currentIndex][total] != null){
          return dp[currentIndex][total];
      }

      int count1 = Integer.MAX_VALUE; int count2 = Integer.MAX_VALUE;
      if(denominations[currentIndex] <= total){
        count1 = countChange(denominations, total - denominations[currentIndex], currentIndex, dp);
        if(count1 != Integer.MAX_VALUE){
            count1 += 1;
        }
    }
      count2 = countChange(denominations, total, currentIndex + 1, dp);
      dp[currentIndex][total] = Math.min(count1, count2);
      return dp[currentIndex][total];
  }

  public static void main(String[] args) {
    MinimumCoinChange cc = new MinimumCoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    denominations = new int[]{3, 5};
    System.out.println(cc.countChange(denominations, 7));
  }


}
