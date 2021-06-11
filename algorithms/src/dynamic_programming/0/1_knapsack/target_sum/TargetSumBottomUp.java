package target_sum;

public class TargetSumBottomUp {
    
    public int findTargetSubsets(int[] nums, int s) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int newSum = (s + sum) / 2;
        int[][] dp = new int[nums.length][newSum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= newSum; i++) {
            if(nums[0] == i){
                dp[0][i] = 1;
            }else{

                dp[0][i] = 0;           
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= newSum; j++) {
                if(nums[i] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[nums.length - 1][newSum];
    }

    public static void main(String[] args) {
       TargetSumBottomUp ts = new TargetSumBottomUp();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
  }
}
