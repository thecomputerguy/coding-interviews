public class MSISBottomUp {

  public int findMSIS(int[] nums) {
    if(nums == null || nums.length == 0){
        return 0;
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int maxSum = 0;
    for (int i = 1; i < nums.length; i++) {
        dp[i] = nums[i];
        for (int j = 0; j < i; j++) {
            if(nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
                dp[i] = dp[j] + nums[i];
                maxSum = Math.max(maxSum, dp[i]);
            }
        }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    MSISBottomUp msis = new MSISBottomUp();
    int[] nums = {4,1,2,6,10,1,12};
    System.out.println(msis.findMSIS(nums));
    nums = new int[]{-4,10,3,7,15};
    System.out.println(msis.findMSIS(nums));
  }

}
