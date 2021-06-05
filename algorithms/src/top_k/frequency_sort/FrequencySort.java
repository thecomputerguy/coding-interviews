import java.util.*;

class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
    if(str == null || str.length() == 0) return str;

    StringBuilder result = new StringBuilder();
    Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
    for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
        maxHeap.offer(entry);
    }

    while(!maxHeap.isEmpty()){

        Map.Entry<Character, Integer> entry = maxHeap.poll();
        int count = entry.getValue();
        while(count > 0){
            result.append(entry.getKey() + "");
            count--;
        }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}
