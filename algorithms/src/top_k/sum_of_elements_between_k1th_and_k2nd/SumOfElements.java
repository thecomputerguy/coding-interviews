import java.util.*;

class SumOfElements {

  public static int findSumOfElements(int[] nums, int k1, int k2) {
    if (nums == null || nums.length == 0 || k1 >= k2) {
        return 0;
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));

    for (int i = 0; i < nums.length; i++) {
        minHeap.offer(nums[i]);   
    }

    int howMany = k2 - k1 - 1;
    while (k1 > 0) {
        minHeap.poll();
        k1--;
    }

    int i = 0;
    int sum = 0;
    while(i < howMany) {
        sum += minHeap.poll();
        i++;
    }

    return sum;
  }

  public static void main(String[] args) {
    int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

    result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
    System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
  }
}
