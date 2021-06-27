public class LBSBottomUp {

  private int findLBSLength(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int maxLength = 0;
    int[] dp = new int[nums.length];
    int[] dpRev = new int[nums.length];

    //longest decreasing subsequence from start to i
    for (int i = 0; i < nums.length; i++) {
        dp[i] = 1; //Length 1 subsequence
        for (int j = i - 1; j >= 0; j--) {
            if(nums[j] < nums[i]){
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
    }

    //longest decreasing subsequence from i to end
    for (int i = nums.length - 1; i >= 0; i--) {
        dpRev[i] = 1; //Length 1 subsequence
        for (int j = i + 1; j < nums.length; j++) {
            if(nums[j] < nums[i]){
                dpRev[i] = Math.max(dpRev[i], 1 + dpRev[j]);
            }
        }
    }

    //longest biotonic subsequence will be the maximum of addition of two subsequences
    for (int i = 0; i < nums.length; i++) {
        maxLength = Math.max(maxLength, dp[i] + dpRev[i] - 1);
    }
    return maxLength;
  }


  public static void main(String[] args) {
    LBSBottomUp lbs = new LBSBottomUp();
    int[] nums = {4,2,3,6,10,1,12};
    System.out.println(lbs.findLBSLength(nums));
    nums = new int[]{4,2,5,9,7,6,10,3,1};
    System.out.println(lbs.findLBSLength(nums));
  }

}
