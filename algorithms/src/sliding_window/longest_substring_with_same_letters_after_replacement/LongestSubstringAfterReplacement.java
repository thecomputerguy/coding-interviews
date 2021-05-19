import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAfterReplacement {
    
    public static int longestSubstring(String input, int K){
        if(input == null || input.length() == 0) return 0;
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        int frequentCharacterFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char f = input.charAt(windowEnd);
            map.put(f, map.getOrDefault(f, 0) + 1);
            frequentCharacterFrequency = Math.max(frequentCharacterFrequency, map.get(f));

            //Remaining characters size is greater than then shrink window size.
            if (windowEnd - windowStart + 1 - frequentCharacterFrequency > K) {
                char startChar = input.charAt(windowStart);
                map.put(startChar, map.get(startChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        
        int result = LongestSubstringAfterReplacement.longestSubstring("aabccbb", 2);
        System.out.println("Longest substring after replacement is " + result);
        int result1 = LongestSubstringAfterReplacement.longestSubstring("abbcb", 1);
        System.out.println("Longest substring after replacement is " + result1);
        int result2 = LongestSubstringAfterReplacement.longestSubstring("abccde", 1);
        System.out.println("Longest substring after replacement is " + result2);
    }
}
