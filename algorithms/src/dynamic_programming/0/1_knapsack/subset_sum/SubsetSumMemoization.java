package subset_sum;

public class SubsetSumMemoization{
    
    public boolean canPartition(int[] nums, int sum){
        if(nums == null || nums.length == 0){
            return false;
        }
        
        return canPartitionRecursive(nums, sum, 0, new Boolean[nums.length][sum+1]);
    }

    public boolean canPartitionRecursive(int[] nums, int sum, int currentIndex, Boolean[][] dp){

        
        //have we crossed bounds, if we have then return false
        if(nums.length <= currentIndex){
            return false;
        }

        //if we have result in the cache then return result from the cache
        if(dp[currentIndex][sum] != null){
            return dp[currentIndex][sum];
        }

        //if the sum has become zero return true
        if(sum == 0){
            return true;
        }


        if(nums[currentIndex] <= sum){
            if(canPartitionRecursive(nums, sum - nums[currentIndex], currentIndex + 1, dp)){
                dp[currentIndex][sum] = true;
                return dp[currentIndex][sum];
            }
        }

        dp[currentIndex][sum] = canPartitionRecursive(nums, sum, currentIndex + 1, dp);
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        SubsetSumMemoization ss = new SubsetSumMemoization();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));   
    }
}