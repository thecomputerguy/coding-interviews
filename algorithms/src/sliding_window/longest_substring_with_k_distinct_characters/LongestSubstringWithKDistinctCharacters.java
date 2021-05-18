import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    

    public static int longestSubstring(String input, int K){
        if(input == null || input.length() == 0 || input.length() < K) return 0;
        Map<Character, Integer> charFrequencies = new HashMap<>();

        int windowStart = 0, maximumLength = 0;
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char f = input.charAt(windowEnd);
            charFrequencies.put(f, charFrequencies.getOrDefault(f, 0) + 1);
            while (charFrequencies.size() > K) {
                charFrequencies.put(input.charAt(windowStart), charFrequencies.get(input.charAt(windowStart)) - 1);
                if(charFrequencies.get(input.charAt(windowStart)) <= 0){
                    charFrequencies.remove(input.charAt(windowStart));
                }                
                windowStart++;
            }
            
            maximumLength = Math.max(maximumLength, windowEnd - windowStart + 1);
        }

        return maximumLength;
    }

    public static void main(String[] args) {
      
        int longestSubstringSize = LongestSubstringWithKDistinctCharacters.longestSubstring("araaci", 2);
        System.out.println("Longest substring with k distinct characters is " + longestSubstringSize);
        
        int longestSubstringSize1 = LongestSubstringWithKDistinctCharacters.longestSubstring("araaci", 1);
        System.out.println("Longest substring with k distinct characters is " + longestSubstringSize1);
        
        int longestSubstringSize2 = LongestSubstringWithKDistinctCharacters.longestSubstring("cbbebi", 3);
        System.out.println("Longest substring with k distinct characters is " + longestSubstringSize2);
    }
}
