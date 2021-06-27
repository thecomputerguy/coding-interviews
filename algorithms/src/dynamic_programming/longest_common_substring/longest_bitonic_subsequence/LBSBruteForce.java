class LBSBruteForce {

  private int findLBSLength(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
        int c1 = findLBSLengthRecursive(nums, i, -1);        
        int c2 = findLBSLengthRevRecursive(nums, i, -1);
        maxLength = Math.max(maxLength, c1 + c2 - 1);
    }
    return maxLength;
  }

  private int findLBSLengthRecursive(int[] nums, int currentIndex, int previousIndex){
    if(currentIndex == nums.length){
        return 0;
    }
    int c1 = 0;
    if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex]){
        c1 = 1 + findLBSLengthRecursive(nums, currentIndex + 1, currentIndex);
    }
    int c2 = findLBSLengthRecursive(nums, currentIndex + 1, previousIndex);
    return Math.max(c1, c2);
  }

  private int findLBSLengthRevRecursive(int[] nums, int currentIndex, int previousIndex){
    if(currentIndex < 0){
        return 0;
    }
    int c1 = 0;
    if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex]){
         c1 = 1 + findLBSLengthRevRecursive(nums, currentIndex - 1, currentIndex);
    }
    int c2 = findLBSLengthRevRecursive(nums, currentIndex - 1, previousIndex);
    return Math.max(c1, c2);
}

  public static void main(String[] args) {
    LBSBruteForce lbs = new LBSBruteForce();
    int[] nums = {4,2,3,6,10,1,12};
    System.out.println(lbs.findLBSLength(nums));
    nums = new int[]{4,2,5,9,7,6,10,3,1};
    System.out.println(lbs.findLBSLength(nums));
  }
}
