public class LISMemoization {

  public int findLISLength(int[] nums) {
      if(nums == null || nums.length == 0){
        return 0;
      }

      return findLISLengthRecursive(nums, 0, -1, new Integer[nums.length][nums.length + 1]);
  }

  private int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex, Integer[][] dp){
    if(currentIndex == nums.length){
        return 0;
    }

    if(dp[currentIndex][previousIndex + 1] != null){
        return dp[currentIndex][previousIndex + 1];
    }

    int c1 = 0;
    if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
         c1 = 1 + findLISLengthRecursive(nums, currentIndex + 1, currentIndex, dp);        
    }

    int c2 = findLISLengthRecursive(nums, currentIndex + 1, currentIndex, dp);

    dp[currentIndex][previousIndex + 1] = Math.max(c1, c2);
    return dp[currentIndex][previousIndex + 1];
  }

  public static void main(String[] args) {
    LISMemoization lis = new LISMemoization();
    int[] nums = {4,2,3,6,10,1,12};
    System.out.println(lis.findLISLength(nums));
    nums = new int[]{-4,10,3,7,15};
    System.out.println(lis.findLISLength(nums));
  }

}
