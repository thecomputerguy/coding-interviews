import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

    public static String findSubstring(String input, String pattern){

        if(input == null || input.length() == 0 || pattern == null || pattern.length() == 0 || pattern.length() > input.length()) return "";

        int windowStart = 0, matched = 0, subStrStart = 0, minLength = input.length() + 1;
        Map<Character, Integer> chars = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char f = pattern.charAt(i);
            chars.put(f, chars.getOrDefault(f, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char rightChar = input.charAt(windowEnd);
            if (chars.containsKey(rightChar)){
                chars.put(rightChar, chars.get(rightChar) - 1);
                if (chars.get(rightChar) >= 0) {
                    
                    matched++;
                }
            }

            while (matched == pattern.length()) {
                
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }
                char leftChar = input.charAt(windowStart);
                if (chars.containsKey(leftChar)) {
                    if (chars.get(leftChar) == 0) {
                        matched--;
                    }
                chars.put(leftChar, chars.get(leftChar) + 1);
                }
                
                windowStart++;
            }
        }

        return minLength == input.length() + 1 ? "" : input.substring(subStrStart, subStrStart + minLength);
    }
    
    public static void main(String[] args) {
        
    System.out.println(SmallestWindowContainingSubstring.findSubstring("aabdec", "abc"));
    System.out.println(SmallestWindowContainingSubstring.findSubstring("abdbca", "abc"));
    System.out.println(SmallestWindowContainingSubstring.findSubstring("adcad", "abc"));

    }
}
