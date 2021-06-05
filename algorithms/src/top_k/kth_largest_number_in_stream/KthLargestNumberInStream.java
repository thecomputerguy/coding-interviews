import java.util.PriorityQueue;

public class KthLargestNumberInStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int K;
    public KthLargestNumberInStream(int[] array, int K){
        this.K = K;
        for (int i = 0; i < array.length; i++) {
            add(array[i]);    
        }
    }

    public int add(int value) {
        this.minHeap.offer(value);
        if(minHeap.size() > K){
            minHeap.poll();
        }

        return minHeap.peek();
    }
    
    public static void main(String[] args) {

        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
