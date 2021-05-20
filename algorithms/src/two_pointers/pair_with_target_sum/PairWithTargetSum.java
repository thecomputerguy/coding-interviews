public class PairWithTargetSum {
    
    public static int[] search(int[] array, int K){
        int[] result = new int[]{-1,-1};
        if(array == null || array.length == 0){
            return result;
        }

        int left = 0, right = array.length-1;

        while(left < right){
            int leftElement = array[left];
            int rightElement = array[right];
            int sum = leftElement + rightElement;
            if(sum == K){
                 result[0] = left;
                 result[1] = right;
                 return result;
            }else if(sum > K){
                right--;
            }else{
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
    int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }
}
