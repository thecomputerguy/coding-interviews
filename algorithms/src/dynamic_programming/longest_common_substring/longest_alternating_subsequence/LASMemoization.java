import java.util.*;
public class LASMemoization {
        
  public int findLASLength(int[] nums) {
      Map<String, Integer> dp = new HashMap<>();
    return Math.max(findLASLengthRecursive(nums, 0, -1, true, dp), findLASLengthRecursive(nums, 0, 1, false, dp));
  }

  private int findLASLengthRecursive(int[] nums, int currentIndex, int previousIndex, boolean isAsc, Map<String, Integer> dp){
    if(currentIndex == nums.length) return 0;
    if(dp.containsKey(currentIndex + " | " + previousIndex + " | " + isAsc)){
        return dp.get(currentIndex + " | " + previousIndex + " | " + isAsc);
    }
    int c1 = 0;
    if(isAsc){
        if(previousIndex == -1 || nums[previousIndex] < nums[currentIndex]){
            c1 = 1 + findLASLengthRecursive(nums, currentIndex + 1, currentIndex, !isAsc, dp);
        }
    }else{
        if(previousIndex == -1 || nums[previousIndex] > nums[currentIndex]){
            c1 =  1 + findLASLengthRecursive(nums, currentIndex + 1, currentIndex, !isAsc, dp);
        }
    }
    int c2 = findLASLengthRecursive(nums, currentIndex + 1, previousIndex, isAsc, dp);
    dp.put(currentIndex + " | " + previousIndex + " | " + isAsc, Math.max(c1 , c2));
    return dp.get(currentIndex + " | " + previousIndex + " | " + isAsc);
  }

  public static void main(String[] args) {
    LASMemoization las = new LASMemoization();
    int[] nums = {1,2,3,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{3,2,1,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{1,3,2,4};
    System.out.println(las.findLASLength(nums));
  }

}
