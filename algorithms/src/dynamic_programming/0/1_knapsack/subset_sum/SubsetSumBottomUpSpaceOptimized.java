package subset_sum;

public class SubsetSumBottomUpSpaceOptimized {
    
    public boolean canPartition(int[] nums, int sum) {
        if(nums == null || sum == 0 || nums.length == 0) return false;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int s = 1; s <= sum; s++) {
            if(nums[0] == s){
                dp[s] = true;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if(!dp[s] && nums[i] <= s){
                    dp[s] = dp[s - nums[i]];
                }
            }           
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        SubsetSumBottomUpSpaceOptimized ss = new SubsetSumBottomUpSpaceOptimized();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));   
    }
}
