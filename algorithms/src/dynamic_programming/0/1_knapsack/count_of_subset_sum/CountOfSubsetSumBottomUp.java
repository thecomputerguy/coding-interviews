package count_of_subset_sum;

public class CountOfSubsetSumBottomUp {
    
    public int countSubsets(int[] nums, int sum){
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            if(nums[0] == s){
                dp[0][s] = 1;
            }else{
                dp[0][s] = 0;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if(nums[i] <= s){
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
                dp[i][s] += dp[i - 1][s];               
            }
        }
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        
        CountOfSubsetSumBottomUp ss = new CountOfSubsetSumBottomUp();
        int[] num = { 1, 1, 2, 3 };
        System.out.println(ss.countSubsets(num, 4));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.countSubsets(num, 9));
    }
}
