import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    
    public static List<Integer> findWordConcatenation(String str, String[] words){
        List<Integer> result = new ArrayList<Integer>();
        if(str == null || str.length() == 0 || words == null || words.length == 0) return result;
        Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
        for(String word : words){
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        int wordCount = words.length; int wordLength = words[0].length();
        for (int i = 0; i <= str.length() - wordCount * wordLength; i++) {
            Map<String, Integer> timesSeen = new HashMap<String, Integer>();
            for (int j = 0; j < wordCount; j++) {
                int nextWordIndex = i + j * wordLength;
                String nextWord = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!frequencyMap.containsKey(nextWord)) {
                    break;
                }
                timesSeen.put(nextWord, timesSeen.getOrDefault(nextWord, 0) + 1);
                
                if (timesSeen.get(nextWord) > frequencyMap.getOrDefault(nextWord, 0)) {
                    break;
                }

                if (j + 1 == wordCount) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
    List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
    System.out.println(result);
    result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
    System.out.println(result);
    }
}
