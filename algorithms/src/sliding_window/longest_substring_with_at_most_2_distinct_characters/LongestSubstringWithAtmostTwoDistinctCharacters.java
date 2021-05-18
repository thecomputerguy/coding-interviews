import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctCharacters {
    
    public static int longestSubstring(String input){
        if(input == null || input.length() == 0) return 0;
        int distinctLength = 2;
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> chars = new HashMap<>();
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char f = input.charAt(windowEnd);
            chars.put(f, chars.getOrDefault(f, 0) + 1);
            while (chars.size() > distinctLength) {
                chars.put(f, chars.get(f) - 1);
                if (chars.get(f) == 0) {
                    chars.remove(f);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {        
        int size = LongestSubstringWithAtmostTwoDistinctCharacters.longestSubstring("abccad");
        System.out.println("Longest substring: " + size);
    }
}
