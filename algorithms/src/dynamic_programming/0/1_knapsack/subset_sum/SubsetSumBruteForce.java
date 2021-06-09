package subset_sum;

public class SubsetSumBruteForce {


  public boolean canPartition(int[] nums, int sum) {
    if(nums == null || nums.length == 0) return false;
    
    return canPartitionRecursive(nums, sum, 0);
  }

  private boolean canPartitionRecursive(int[] nums, int sum, int currentIndex){
      if(sum == 0){
        return true;
      }

      if(nums.length <= currentIndex){
        return false;
      }
      if(nums[currentIndex] <= sum){
        if(canPartitionRecursive(nums, sum - nums[currentIndex], currentIndex + 1)){
            return true;
        }
      }
      return canPartitionRecursive(nums, sum, currentIndex + 1);
  }

  public static void main(String[] args) {
    SubsetSumBruteForce ss = new SubsetSumBruteForce();
    int[] num = { 1, 2, 3, 7 };
    System.out.println(ss.canPartition(num, 6));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(ss.canPartition(num, 10));
    num = new int[] { 1, 3, 4, 8 };
    System.out.println(ss.canPartition(num, 6));
  }

}
