package minimum_subset_sum_difference;

public class MinimumSubsetDifferenceBottomUp {
   

  public int canPartition(int[] nums) {
    if(nums == null || nums.length == 0){
        return -1;
    }

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];        
    }
    int s = sum/2;
    boolean[][] dp = new boolean[nums.length][s+1];
    for (int i = 0; i < nums.length; i++) {
        dp[i][0] = true;
    }

    for (int i = 0; i <= s; i++) {
        if(nums[0] == i){
            dp[0][i] = true;
        }
    }

    for (int i = 1; i < nums.length; i++) {
        for (int j = 1; j <= s; j++) {
            if(dp[i-1][j]){
                dp[i][j] = true;
            }else if(nums[i] <= j){
                dp[i][j] = dp[i-1][j-nums[i]];
            }
        }
    }

    //we found the subset which has sum equal to sum/2
    if(dp[nums.length - 1][s]){
        //Minimum absolue difference will be 0 as both the subset will have same sum
        return 0;
    }
        //if we couldn't find a subset equal to sum, then try to find the closest sum
        int sum1 = 0;
        for (int i = s; i >= 0; i--) {
            if(dp[nums.length - 1][i]){
                sum1 = i;
                break;
            }                
        }
        int sum2 = sum - sum1;
         
        return Math.abs(sum1 - sum2);
  }

  

  public static void main(String[] args) {
    MinimumSubsetDifferenceBottomUp ps = new MinimumSubsetDifferenceBottomUp();
    int[] num = {1, 2, 3, 9};
    System.out.println(ps.canPartition(num));
    num = new int[]{1, 2, 7, 1, 5};
    System.out.println(ps.canPartition(num));
    num = new int[]{1, 3, 100, 4};
    System.out.println(ps.canPartition(num));
  }

}
