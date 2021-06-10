package count_of_subset_sum;

public class CountOfSubsetMemoized {
 
    public int countSubsets(int[] nums, int sum){
        if(nums == null || nums.length == 0) return 0;

        return countSubsetsRecursive(nums, sum, 0, new Integer[nums.length][sum+1]);
    }

    private int countSubsetsRecursive(int[] nums, int sum, int currentIndex, Integer[][] dp){
        
        
        if(sum == 0) return 1;
        if(currentIndex >= nums.length) return 0;
        if(dp[currentIndex][sum] != null) return dp[currentIndex][sum];
        int count1 = 0; int count2 = 0;
        if(nums[currentIndex] <= sum){
            count1 = countSubsetsRecursive(nums, sum - nums[currentIndex], currentIndex + 1, dp);
        }
        count2 = countSubsetsRecursive(nums, sum, currentIndex + 1, dp);

        dp[currentIndex][sum] = count1 + count2;
        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        CountOfSubsetMemoized ss = new CountOfSubsetMemoized();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
