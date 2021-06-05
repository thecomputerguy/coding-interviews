import java.util.*;

class RearrangeString {

  public static String rearrangeString(String str) {
    if(str == null || str.length() == 0) return "";
    Map<Character, Integer> frequencyMap = new HashMap<>();
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
    for (int i = 0; i < str.length(); i++) {
        frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);
    }

    for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
        maxHeap.offer(entry);
    }

    Map.Entry<Character, Integer> previousEntry = null;
    StringBuilder result = new StringBuilder();

    while (!maxHeap.isEmpty()) {
        Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
        result.append(currentEntry.getKey() + "");
        if(previousEntry != null && previousEntry.getValue() > 0){
            maxHeap.offer(previousEntry);
        }
        currentEntry.setValue(currentEntry.getValue() - 1);
        previousEntry = currentEntry;
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
  }
}
