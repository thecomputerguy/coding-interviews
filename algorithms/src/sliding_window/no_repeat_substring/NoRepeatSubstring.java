import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
    
    public static int findLength(String input){
        if(input == null || input.length() == 0) return 0;
        Map<Character, Integer> chars = new HashMap<>();
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char f = input.charAt(windowEnd);

            if(chars.containsKey(f)){
                windowStart = Math.max(windowStart,chars.get(f) + 1);
            }
            chars.put(f, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
       System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
