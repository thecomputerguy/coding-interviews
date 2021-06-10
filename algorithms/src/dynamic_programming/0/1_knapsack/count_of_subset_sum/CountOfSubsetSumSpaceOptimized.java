package count_of_subset_sum;

public class CountOfSubsetSumSpaceOptimized {
     
    public int countSubsets(int[] nums, int sum){
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int s = 1; s <= sum; s++) {
            if(nums[0] == s){
                dp[s] = 1;
            }else{
                dp[s] = 0;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if(nums[i] <= s){
                    dp[s] += dp[s - nums[i]];
                }
                
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        
        CountOfSubsetSumSpaceOptimized ss = new CountOfSubsetSumSpaceOptimized();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }


}
