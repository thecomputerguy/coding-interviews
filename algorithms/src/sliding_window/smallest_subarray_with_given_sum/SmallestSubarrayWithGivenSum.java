public class SmallestSubarrayWithGivenSum {
    
    public static int smallestSubarraySize(int[] array, int S){
        if(array == null || array.length == 0) return 0;
        int windowStart = 0, smallestSubarraySize = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            currentSum += array[windowEnd];
            while (currentSum >= S) {
                smallestSubarraySize = Math.min(smallestSubarraySize, windowEnd - windowStart + 1);
                currentSum -= array[windowStart];
                windowStart++;
            }
        }

        return smallestSubarraySize == Integer.MAX_VALUE ? 0 : smallestSubarraySize;
    }   

    public static void main(String[] args) {
        int smallestSubarraySize1 = SmallestSubarrayWithGivenSum.smallestSubarraySize(new int[]{2, 1, 5, 2, 3, 2}, 7);
        System.out.println("Smallest subarray with sum greater than or equal to 7 is " + smallestSubarraySize1);

        int smallestSubarraySize2 = SmallestSubarrayWithGivenSum.smallestSubarraySize(new int[]{2, 1, 5, 2, 8}, 7);
        System.out.println("Smallest subarray with sum greater than or equal to 7 is " + smallestSubarraySize2);

        int smallestSubarraySize3 = SmallestSubarrayWithGivenSum.smallestSubarraySize(new int[]{3, 4, 1, 1, 6}, 8);
        System.out.println("Smallest subarray with sum greater than or equal to 7 is " + smallestSubarraySize3);
    }
}
