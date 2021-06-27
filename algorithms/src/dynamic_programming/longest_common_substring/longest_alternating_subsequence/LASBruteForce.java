public class LASBruteForce {
    
  public int findLASLength(int[] nums) {
    return Math.max(findLASLengthRecursive(nums, 0, -1, true), findLASLengthRecursive(nums, 0, 1, false));
  }

  private int findLASLengthRecursive(int[] nums, int currentIndex, int previousIndex, boolean isAsc){
    if(currentIndex == nums.length) return 0;

    int c1 = 0;
    if(isAsc){
        if(previousIndex == -1 || nums[previousIndex] < nums[currentIndex]){
            c1 = 1 + findLASLengthRecursive(nums, currentIndex + 1, currentIndex, !isAsc);
        }
    }else{
        if(previousIndex == -1 || nums[previousIndex] > nums[currentIndex]){
            c1 =  1 + findLASLengthRecursive(nums, currentIndex + 1, currentIndex, !isAsc);
        }
    }
    int c2 = findLASLengthRecursive(nums, currentIndex + 1, previousIndex, isAsc);
    return Math.max(c1 , c2);
  }

  public static void main(String[] args) {
    LASBruteForce las = new LASBruteForce();
    int[] nums = {1,2,3,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{3,2,1,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{1,3,2,4};
    System.out.println(las.findLASLength(nums));
  }

}
