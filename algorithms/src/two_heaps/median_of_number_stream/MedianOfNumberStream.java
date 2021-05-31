import java.util.PriorityQueue;

public class MedianOfNumberStream {
 
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a, b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

    public void insertNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        rebalance();

    }

    private void rebalance(){
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());            
        }

        while (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian(){
        if (!minHeap.isEmpty() && (minHeap.size() + maxHeap.size()) % 2 == 0) {
            return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        
        MedianOfNumberStream medianOfAStream = new MedianOfNumberStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
