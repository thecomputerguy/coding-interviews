public class HouseThiefMemoization {
     
  public int findMaxSteal(int[] wealth) {
    if(wealth == null || wealth.length == 0){
        return 0;
    }
    return findMaxStealRecursive(wealth, 0, new Integer[wealth.length + 1]);
  }

  private int findMaxStealRecursive(int[] wealth, int currentIndex, Integer[] dp){
    if(currentIndex >= wealth.length){
        return 0;
    }

    if(dp[currentIndex] != null){
        return dp[currentIndex];
    }

    int robHouse = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2, dp);
    int skipHouse = findMaxStealRecursive(wealth, currentIndex + 1, dp);

    dp[currentIndex] = Math.max(robHouse, skipHouse);
    return dp[currentIndex];
  }

  public static void main(String[] args) {
    HouseThiefMemoization ht = new HouseThiefMemoization();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }

}
