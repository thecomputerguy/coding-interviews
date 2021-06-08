package equal_subset_sum_partition;

public class PartitionSetMemoized {
    
    public boolean canPartition(int[] nums){
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0)  return false;
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1]; 
        return canPartitionRecursive(nums, sum / 2, 0, dp);
    }

    private boolean canPartitionRecursive(int[] nums, int sum, int currentIndex, boolean[][] dp){
        if(sum == 0) return true;
        if(currentIndex == nums.length) return false;

        if(nums[currentIndex] <= sum){
            
            if(canPartitionRecursive(nums, sum - nums[currentIndex], currentIndex + 1, dp)){
                dp[currentIndex][sum] = true;
                return true;
            }
        }

        dp[currentIndex][sum] = canPartitionRecursive(nums, sum, currentIndex + 1, dp);
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        
        PartitionSetMemoized ps = new PartitionSetMemoized();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
