import java.util.Arrays;

class AverageOfSubarrayOfSizeK{

    public static double[] findAverage(int k, int[] input){
        if(input == null || input.length == 0) return null;
        int n = input.length;
        double[] result = new double[n - k + 1];
        int windowStart = 0;
        double windowSum = 0;
        for(int windowEnd = 0; windowEnd < n; windowEnd++){
            windowSum += input[windowEnd];
            if(windowEnd >= k-1){
                result[windowStart] = windowSum / k;
                windowSum -= input[windowStart];
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
 
   double[] result = AverageOfSubarrayOfSizeK.findAverage(5, new int[]{ 1, 3, 2, 6, -1, 4, 1, 8, 2 });
    System.out.println("Averages of subarrays of size k " + Arrays.toString(result));
}

}
