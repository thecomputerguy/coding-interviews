package minimum_subset_sum_difference;

public class MinimumSubsetDifferenceMemoized {
    
    public int canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return canPartitionRecursive(nums, 0, 0, 0, new Integer[nums.length][sum + 1]);
    }

    public int canPartitionRecursive(int[] nums, int currentIndex, int sum1, int sum2, Integer[][] dp){
        if(currentIndex >= nums.length){
            return Math.abs(sum1 - sum2);
        }

        if(dp[currentIndex][sum1] != null){
            return dp[currentIndex][sum1];
        }

       int diff1 = canPartitionRecursive(nums, currentIndex + 1, sum1 + nums[currentIndex], sum2, dp);
       int diff2 = canPartitionRecursive(nums, currentIndex + 1, sum1, sum2 + nums[currentIndex], dp);

        dp[currentIndex][sum1] = Math.min(diff1, diff2);
        return dp[currentIndex][sum1];
    }

    public static void main(String[] args) {
        MinimumSubsetDifferenceMemoized ps = new MinimumSubsetDifferenceMemoized();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
