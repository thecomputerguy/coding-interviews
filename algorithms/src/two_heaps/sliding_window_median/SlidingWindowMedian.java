import java.util.PriorityQueue;

public class SlidingWindowMedian{

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));

    public double[] findSlidingWindowMedian(int[] input, int K){
        double[] result = new double[input.length - K + 1];
     
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < input.length; windowEnd++){
                int currentElement = input[windowEnd];
            //add element to the max heap if the maxheap is empty or the element is smaller than the top element
            //of the maxHeap.
            if(maxHeap.isEmpty() || maxHeap.peek() >= currentElement){
                maxHeap.offer(currentElement);
            }else{
                minHeap.offer(currentElement);
            }

            rebalanceHeap();

            if (windowEnd >= K-1) {
                //Calculate median and fill result array.
                if (maxHeap.size() == minHeap.size()) {
                    result[windowStart] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                }else{
                    result[windowStart] = maxHeap.poll();
                }                

                //remove the element from the heap before moving window start.
                int elementGoingOut = input[windowStart];
                if(maxHeap.peek() >= elementGoingOut){
                    maxHeap.remove(elementGoingOut);
                }else{
                    minHeap.remove(elementGoingOut);
                }
                rebalanceHeap();
                //slide the window.
                windowStart++;
            }
        }

        return result;
    }

    private void rebalanceHeap(){
        
            //rebalance the heaps
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }else if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
        System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
        System.out.print(num + " ");
    }
}