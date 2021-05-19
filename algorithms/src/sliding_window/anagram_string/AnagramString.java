import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramString {
    
    public static List<Integer> findAnagrams(String input, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0 || pattern == null || pattern.length() == 0 || pattern.length() > input.length()) return result;
        Map<Character, Integer> chars = new HashMap<>();
        int windowStart = 0; int matched = 0;
        for (int i = 0; i < pattern.length(); i++) {
            chars.put(pattern.charAt(i), chars.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            char f = input.charAt(windowEnd);
            if (chars.containsKey(f)) {
                chars.put(f, chars.get(f) - 1);
                if (chars.get(f) == 0) {
                    matched++;
                }
            }

            if(matched == chars.size()) {
                result.add(windowStart);
            }

            if(windowEnd >= pattern.length() - 1){
                if(chars.containsKey(input.charAt(windowStart))) {
                    if (chars.get(input.charAt(windowStart)) == 0) {
                        matched--;
                    }
                    chars.put(input.charAt(windowStart), chars.get(input.charAt(windowStart)) + 1);
                }
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = AnagramString.findAnagrams("ppqp", "pq");
        System.out.println(anagrams);
        List<Integer> anagrams1 = AnagramString.findAnagrams("abbcabc", "abc");
        System.out.println(anagrams1);
    }
}
