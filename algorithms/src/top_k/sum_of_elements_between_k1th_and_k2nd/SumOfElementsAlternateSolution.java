import java.util.PriorityQueue;

public class SumOfElementsAlternateSolution {
    
    public static int findSumofElements(int[] nums, int k1, int k2){
        if(nums == null || nums.length == 0 || k1 >= k2) return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < k2; i++) {
            maxHeap.offer(nums[i]);
        }

        for (int i = k2; i < nums.length; i++) {
            
            if(nums[i] < maxHeap.peek()){
                maxHeap.offer(nums[i]);
            }
        }

        //Take out k2th
        maxHeap.poll();
        int howMany = k2 - k1 - 1;
        int sum = 0;
        while (howMany > 0) {
            sum += maxHeap.poll();
            howMany--;
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
