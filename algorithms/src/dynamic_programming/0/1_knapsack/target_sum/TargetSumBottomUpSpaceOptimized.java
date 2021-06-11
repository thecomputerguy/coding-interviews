package target_sum;

public class TargetSumBottomUpSpaceOptimized {
    
    public int findTargetSubsets(int[] nums, int s) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];            
        }
        int newSum = (s + sum) / 2;
        int[] dp = new int[newSum + 1];
        dp[0] = 1;
        for (int i = 1; i <= newSum; i++) {
            if(nums[0] == i){
                dp[i] = 1;
            }else{
                dp[i] = 0;
            }           
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = newSum; j >= 0; j--) {
                if(nums[i] <= j){
                    dp[j] += dp[j - nums[i]];
                }               
            }
        }

        return dp[newSum];
    }

    public static void main(String[] args) {
        TargetSumBottomUpSpaceOptimized ts = new TargetSumBottomUpSpaceOptimized();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
  }
}
