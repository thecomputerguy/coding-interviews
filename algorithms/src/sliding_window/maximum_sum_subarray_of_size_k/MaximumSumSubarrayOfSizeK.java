public class MaximumSumSubarrayOfSizeK {
    
    public static int maximumSubarraySum(int[] array, int k){
        int windowStart = 0, maximumSum = Integer.MIN_VALUE;

        int currentSum = 0;
        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
            currentSum += array[windowEnd];
            //check if window is of size k. Compare the currentSum with max sum
            //Whichever is greater that will become maxSum.
            //Also, shrink window from start.
            if(windowEnd >= k-1){
                maximumSum = Math.max(maximumSum, currentSum);
                currentSum -= array[windowStart];
                windowStart++;
            }
        }

        return maximumSum;
    }

    public static void main(String[] args){
        int maxSum = MaximumSumSubarrayOfSizeK.maximumSubarraySum(new int[]{2, 3, 4, 1, 5}, 2);
        System.out.println("maxSum " + maxSum);
    }
}
