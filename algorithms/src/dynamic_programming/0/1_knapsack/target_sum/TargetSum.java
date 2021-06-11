package target_sum;

public class TargetSum {

  public int findTargetSubsets(int[] nums, int s) {
    if(nums == null || nums.length == 0) return -1;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
    }    
    return findTargetSubsetsRecursive(nums, (s + sum) / 2, 0);
  }

  private int findTargetSubsetsRecursive(int[] nums, int sum, int currentIndex){
    if(sum == 0) return 1;
    if(currentIndex >= nums.length) return 0;
    int count1 = 0; int count2 = 0;
    if(nums[currentIndex] <= sum){
        count1 = findTargetSubsetsRecursive(nums, sum - nums[currentIndex], currentIndex + 1);
    }
    count2 = findTargetSubsetsRecursive(nums, sum, currentIndex + 1);

    return count1 + count2;
  }
  
  public static void main(String[] args) {
    TargetSum ts = new TargetSum();
    int[] num = {1, 1, 2, 3};
    System.out.println(ts.findTargetSubsets(num, 1));
    num = new int[]{1, 2, 7, 1};
    System.out.println(ts.findTargetSubsets(num, 9));
  }

}
