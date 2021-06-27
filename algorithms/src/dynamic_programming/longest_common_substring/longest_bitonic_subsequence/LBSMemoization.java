public class LBSMemoization {

  private int findLBSLength(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
        int c1 = findLBSLengthRecursive(nums, i, -1, new Integer[nums.length][nums.length + 1]);        
        int c2 = findLBSLengthRevRecursive(nums, i, -1, new Integer[nums.length][nums.length + 1]);
        maxLength = Math.max(maxLength, c1 + c2 - 1);
    }
    return maxLength;
  }

  private int findLBSLengthRecursive(int[] nums, int currentIndex, int previousIndex, Integer[][] dp){
    if(currentIndex == nums.length){
        return 0;
    }
    if(dp[currentIndex][previousIndex + 1] != null){
        return dp[currentIndex][previousIndex + 1];
    }
    int c1 = 0;
    if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex]){
        c1 = 1 + findLBSLengthRecursive(nums, currentIndex + 1, currentIndex, dp);
    }
    int c2 = findLBSLengthRecursive(nums, currentIndex + 1, previousIndex, dp);
    dp[currentIndex][previousIndex + 1] = Math.max(c1, c2);
    return dp[currentIndex][previousIndex + 1];
  }

  private int findLBSLengthRevRecursive(int[] nums, int currentIndex, int previousIndex, Integer[][] dp){
    if(currentIndex < 0){
        return 0;
    }
    if(dp[currentIndex][previousIndex + 1] != null){
        return dp[currentIndex][previousIndex + 1];
    }
    int c1 = 0;
    if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex]){
         c1 = 1 + findLBSLengthRevRecursive(nums, currentIndex - 1, currentIndex, dp);
    }
    int c2 = findLBSLengthRevRecursive(nums, currentIndex - 1, previousIndex, dp);
    dp[currentIndex][previousIndex + 1] =  Math.max(c1, c2);
    return dp[currentIndex][previousIndex + 1];
}

  public static void main(String[] args) {
    LBSMemoization lbs = new LBSMemoization();
    int[] nums = {4,2,3,6,10,1,12};
    System.out.println(lbs.findLBSLength(nums));
    nums = new int[]{4,2,5,9,7,6,10,3,1};
    System.out.println(lbs.findLBSLength(nums));
  }

}
