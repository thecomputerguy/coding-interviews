import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianAmongAllArrays {

    public static int findMedian(List<Integer[]> lists) {
        PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>((a, b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);
        int N = 0;
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null || lists.get(i).length != 0){
                N += lists.get(i).length;                
                minHeap.offer(new ArrayElement(0, i));
            }
        }

        int count = 0; int median = 0;
        int k = N/2;
        while(!minHeap.isEmpty()){
            ArrayElement element = minHeap.poll();
            median = lists.get(element.arrayIndex)[element.elementIndex];
            if(++count == k){
                break;
            }
            element.elementIndex++;
            if(lists.get(element.arrayIndex).length > element.elementIndex){
                minHeap.offer(element);
            }
        }

        return median;
    }

    public static void main(String[] args) {
        
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = MedianAmongAllArrays.findMedian(lists);
        System.out.print("Kth smallest number is: " + result);
    }
}