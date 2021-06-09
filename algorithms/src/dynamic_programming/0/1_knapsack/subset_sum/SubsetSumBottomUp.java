package subset_sum;

public class SubsetSumBottomUp {
    
    public boolean canPartition(int[] nums, int sum) {
        if(nums == null || nums.length == 0){
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int s = 0; s <= sum; s++) {
            if(nums[0] == s){
                dp[0][s] = true;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = 0; s <= sum; s++) {
                if(dp[i-1][s]){

                    dp[i][s] = dp[i-1][s];
                }
                else if (nums[i] <= s) {
                    dp[i][s] = dp[i-1][s-nums[i]];
                }
            }
        }

        return dp[nums.length-1][sum];

    }

    public static void main(String[] args) {
        
        SubsetSumBottomUp ss = new SubsetSumBottomUp();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));   
    }
}
