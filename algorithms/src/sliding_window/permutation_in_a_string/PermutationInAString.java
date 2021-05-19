import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

    public static boolean findPermutation(String input, String pattern){
        if(input == null || pattern == null || input.length() == 0 || pattern.length() == 0 || input.length() < pattern.length()) return false;

        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> chars = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++){
            char pattChar = pattern.charAt(i);
            chars.put(pattChar, chars.getOrDefault(pattChar, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char f = input.charAt(windowEnd);
            if(chars.containsKey(f)){
                chars.put(f, chars.get(f) - 1);            
                if(chars.get(f) == 0){
                    matched++;
                }
            }

            if(matched == chars.size()) return true;

            if (windowEnd >= pattern.length()-1) {
                char charAtStart = input.charAt(windowStart);
                if (chars.containsKey(charAtStart)) {
                    if(chars.get(charAtStart) == 0)
                        matched--;
                    
                    chars.put(charAtStart, chars.get(charAtStart) + 1);
                }
                windowStart++;
            }

        }
        
        return false;
    }

    public static void main(String[] args) {
        
        boolean result = PermutationInAString.findPermutation("oidbcaf", "abc");
        System.out.println("Result " + result);
        boolean result1 = PermutationInAString.findPermutation("odicf", "dc");
        System.out.println("Result1 " + result1);
        boolean result2 = PermutationInAString.findPermutation("bcdxabcdy", "bcdyabcdx");
        System.out.println("Result2 " + result2);
        boolean result3 = PermutationInAString.findPermutation("aaacb", "abc");
        System.out.println("Result3 " + result3);
    }
}
