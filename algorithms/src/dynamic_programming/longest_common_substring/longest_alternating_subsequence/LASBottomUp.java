public class LASBottomUp {
           
  public int findLASLength(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    
    int[][] dp = new int[nums.length][2];
    int maxLength = 1;

    for(int i = 0; i < nums.length; i++){
      dp[i][0] = 1; dp[i][1] = 1;
      for(int j = 0; j < i; j++){
        if(nums[i] > nums[j]){
          dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
          maxLength = Math.max(maxLength, dp[i][0]);
        }else if(nums[i] != nums[j]){
          dp[i][1] = Math.max(dp[i][1], 1 + dp[i][0]);
          maxLength = Math.max(maxLength, 1 + dp[i][1]);
        }
      }
    }
    return maxLength;
  }

  
  public static void main(String[] args) {
    LASBottomUp las = new LASBottomUp();
    int[] nums = {1,2,3,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{3,2,1,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{1,3,2,4};
    System.out.println(las.findLASLength(nums));
  }

}
