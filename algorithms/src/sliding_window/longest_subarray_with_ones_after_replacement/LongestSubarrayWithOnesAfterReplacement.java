import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithOnesAfterReplacement {
    
    public static int longestSubarray(int[] array, int K){
        int windowStart = 0; int maxLength = Integer.MIN_VALUE;
        int maxOnesCount = 0;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            int f = array[windowEnd];
            if (f == 1) {
                maxOnesCount++;
            }

            if(windowEnd - windowStart + 1 - maxOnesCount > K){
                int valAtStart = array[windowStart];
                if(valAtStart == 1) maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        
       int result = LongestSubarrayWithOnesAfterReplacement.longestSubarray(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2);
       System.out.println("Longest subarray with ones after replacement " + result);

       int result1 = LongestSubarrayWithOnesAfterReplacement.longestSubarray(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3);
       System.out.println("Longest subarray with ones after replacement " + result1);
    }
}
