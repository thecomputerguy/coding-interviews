import java.util.*;

class KLargestNumbers {

  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    
    if(nums == null || nums.length == 0 || k <= 0) return new ArrayList<Integer>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
        minHeap.offer(nums[i]);
    }

    for (int i = k; i < nums.length; i++) {
        int element = nums[i];
        if(element > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(element);
        }
    }
    return new ArrayList<>(minHeap);
  }

  public static void main(String[] args) {
    List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
    System.out.println("Here are the top K numbers: " + result);

    result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Here are the top K numbers: " + result);
  }
}
