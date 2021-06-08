package equal_subset_sum_partition;

public class PartitionSumBottomUp {
    
    public boolean canPartition(int[] nums){
        if(nums == null || nums.length == 0){
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0){
            return false;
        }

        boolean[][] dp = new boolean[nums.length][sum+1];
        //when zero sum
        for (int j = 0; j < nums.length; j++) {
            dp[j][0] = true;
        }

        //when only one number
        for (int s = 0; s <= sum; s++) {
            if(nums[0] == s){
                dp[0][s] = true;
            }
        }


        for (int j = 1; j < nums.length; j++) {
            for (int s = 1; s <= sum; s++) {
                if(dp[j-1][s]){
                    dp[j][s] = dp[j-1][s];
                }else if(nums[j] <= s){
                    dp[j][s] = dp[j-1][s-nums[j]];
                }
            }
        }


        return dp[nums.length-1][sum];

    }

    public static void main(String[] args) {
        PartitionSumBottomUp ps = new PartitionSumBottomUp();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
