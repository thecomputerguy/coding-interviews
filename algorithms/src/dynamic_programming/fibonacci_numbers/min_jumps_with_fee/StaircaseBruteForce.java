public class StaircaseBruteForce {

  public int findMinFee(int[] fee) {
    if(fee == null || fee.length == 0) return Integer.MAX_VALUE;
    return findMinFeeRecursive(fee, 0);
  }

  private int findMinFeeRecursive(int[] fee, int currentIndex){
      if(currentIndex >= fee.length){
        return 0;
      }
      int fee1 = findMinFeeRecursive(fee, currentIndex + 1);
      int fee2 = findMinFeeRecursive(fee, currentIndex + 2);
      int fee3 = findMinFeeRecursive(fee, currentIndex + 3);
      int minFee = Math.min(fee1, Math.min(fee2, fee3));
      return minFee + fee[currentIndex];
    }
  
  public static void main(String[] args) {
    StaircaseBruteForce sc = new StaircaseBruteForce();
    int[] fee = {1,2,5,2,1,2};
    System.out.println(sc.findMinFee(fee));
    fee = new int[]{2,3,4,5};
    System.out.println(sc.findMinFee(fee));
  }


}
