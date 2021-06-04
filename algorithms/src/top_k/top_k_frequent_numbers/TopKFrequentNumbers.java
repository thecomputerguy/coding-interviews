import java.util.*;

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> hashmap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
       hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1); 
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

    for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
        minHeap.offer(entry);
        if(minHeap.size() > k){
            minHeap.poll();
        }
    }

    while(!minHeap.isEmpty()){
        result.add(minHeap.poll().getKey());
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}
