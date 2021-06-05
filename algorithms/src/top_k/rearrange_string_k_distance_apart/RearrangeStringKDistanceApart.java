import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {
    
    public static String reorganizeString(String str, int K){
        if(K <= 0 || str == null || str.length() == 0) return str;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        //Go through each character and put it in the frequency map.
        for (int i = 0; i < str.length(); i++) {
            frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            maxHeap.offer(entry);
        }

        
        StringBuilder result = new StringBuilder(str.length());
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.offer(currentEntry);
            if(!queue.isEmpty() && queue.size() == K){
                Map.Entry<Character, Integer> previousEntry = queue.poll();
                if(previousEntry.getValue() > 0){
                    maxHeap.offer(previousEntry);
                }
            }
        }

        return result.length() == str.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        
            System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
            System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
            System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
            System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
