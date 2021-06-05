import java.util.*;

class MaximumDistinctElements {

  public static int findMaximumDistinctElements(int[] nums, int k) {
    int maximumDistinctCount = 0;

    if(nums == null || nums.length == 0 || nums.length <= k){
        return 0;
    }

    Map<Integer, Integer> frequencyMap = new  HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
    for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
        if(entry.getValue() == 1){
            maximumDistinctCount++;
        }else{
            minHeap.offer(entry);
        }
    }

    while(k > 0 && !minHeap.isEmpty()){
        Map.Entry<Integer, Integer> entry = minHeap.poll();
        k -= entry.getValue() - 1;
        if(k >= 0){
            maximumDistinctCount++;
        }
    }

    if(k > 0){
        maximumDistinctCount -= k;
    }


    return maximumDistinctCount;
  }

  public static void main(String[] args) {
    int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);
  }
}