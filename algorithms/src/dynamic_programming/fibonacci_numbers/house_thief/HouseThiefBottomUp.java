public class HouseThiefBottomUp {
    
  public int findMaxSteal(int[] wealth) {
    if(wealth == null || wealth.length == 0){
        return 0;
    }

    int[] dp = new int[wealth.length + 1];
    dp[0] = 0;
    dp[1] = wealth[0];
    for (int i = 2; i <= wealth.length; i++) {
        int robHouse = wealth[i-1] + dp[i - 2];
        int skipHouse = dp[i - 1];
        dp[i] = Math.max(robHouse, skipHouse);        
    }

    return dp[wealth.length];
  }

  public static void main(String[] args) {
    HouseThiefBottomUp ht = new HouseThiefBottomUp();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }

}
