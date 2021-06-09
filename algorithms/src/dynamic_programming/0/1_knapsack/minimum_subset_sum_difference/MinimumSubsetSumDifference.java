package minimum_subset_sum_difference;

class MinimumSubsetSumDifference {

  public int canPartition(int[] nums) {
    if(nums == null || nums.length == 0){
        return -1;
    }

    return canPartitionRecursive(nums, 0, 0, 0);
  }

  public int canPartitionRecursive(int[] nums, int currentIndex, int sum1, int sum2){
      if(currentIndex == nums.length){
        return Math.abs(sum1 - sum2);
      }

      //include the number in the first set
      int diff1 = canPartitionRecursive(nums, currentIndex + 1, sum1 + nums[currentIndex], sum2);

      //include the number in second set
      int diff2 = canPartitionRecursive(nums, currentIndex + 1, sum1, sum2 + nums[currentIndex]);

      return Math.min(diff1, diff2);
  }

  public static void main(String[] args) {
    MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
    int[] num = {1, 2, 3, 9};
    System.out.println(ps.canPartition(num));
    num = new int[]{1, 2, 7, 1, 5};
    System.out.println(ps.canPartition(num));
    num = new int[]{1, 3, 100, 4};
    System.out.println(ps.canPartition(num));
  }
}