import java.util.HashMap;
import java.util.Map;

class MSISMemoization {

  public int findMSIS(int[] nums) {
    if(nums == null || nums.length == 0){
        return 0;
    }
    Map<String, Integer> dp = new HashMap<String, Integer>();
     
    return findMSIS(nums, 0, -1, 0, dp);
  }

  private int findMSIS(int[] nums, int currentIndex, int previousIndex, int sum, Map<String, Integer> dp){
    if(currentIndex == nums.length){
        return sum;
    }

    if(dp.containsKey(currentIndex + "|" + previousIndex + "|" + sum)){
        return dp.get(currentIndex + "|" + previousIndex + "|" + sum);
    }

    int s1 = sum;
    if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex]){
         s1 = findMSIS(nums, currentIndex + 1, currentIndex, sum + nums[currentIndex], dp);
    }

    int s2 = findMSIS(nums, currentIndex + 1, previousIndex, sum, dp);

    dp.put(currentIndex + "|" + previousIndex + "|" + sum, Math.max(s1, s2));
    
    return dp.get(currentIndex + "|" + previousIndex + "|" + sum);  

}

  public static void main(String[] args) {
    MSISMemoization msis = new MSISMemoization();
    int[] nums = {4,1,2,6,10,1,12};
    System.out.println(msis.findMSIS(nums));
    nums = new int[]{-4,10,3,7,15};
    System.out.println(msis.findMSIS(nums));
  }
}
