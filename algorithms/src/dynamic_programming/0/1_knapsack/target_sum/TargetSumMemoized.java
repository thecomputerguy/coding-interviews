package target_sum;

public class TargetSumMemoized {

  public int findTargetSubsets(int[] nums, int s) {
    if(nums == null || nums.length == 0) return -1;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
    int newSum = (s + sum) / 2;    
    return findTargetSubsetsRecursive(nums, newSum, 0, new Integer[nums.length][newSum + 1]);
  }

  private int findTargetSubsetsRecursive(int[] nums, int sum, int currentIndex, Integer[][] dp){
    if(sum == 0) return 1;
    if(currentIndex >= nums.length) return 0;
    if(dp[currentIndex][sum] != null){
        return dp[currentIndex][sum];
    }
    
    if(nums[currentIndex] <= sum){
        dp[currentIndex][sum] = findTargetSubsetsRecursive(nums, sum - nums[currentIndex], currentIndex + 1, dp);
    }
    dp[currentIndex][sum] += findTargetSubsetsRecursive(nums, sum, currentIndex + 1, dp);

    return dp[currentIndex][sum];
  }
  
  public static void main(String[] args) {
    TargetSum ts = new TargetSum();
    int[] num = {1, 1, 2, 3};
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[]{1, 2, 7, 1};
    System.out.println(ts.findTargetSubsets(num, 9));
  }

}
