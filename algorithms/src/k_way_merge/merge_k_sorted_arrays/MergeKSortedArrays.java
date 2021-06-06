import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    
    public static List<Integer> mergeKArrays(List<Integer[]> lists){
        
        PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>((a, b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);
        
        int i = 0;
        
        for (Integer[] list : lists) {
            if(lists != null || list.length != 0){
                minHeap.offer(new ArrayElement(0, i));
            }
            i++;
        }

        List<Integer> result = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            ArrayElement element = minHeap.poll();
            result.add(lists.get(element.arrayIndex)[element.elementIndex]);
            element.elementIndex++;
            if(lists.get(element.arrayIndex).length > element.elementIndex){
                minHeap.offer(element);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        List<Integer> result = MergeKSortedArrays.mergeKArrays(lists);
        System.out.println("Result: ");
        System.out.print(result);
    }
}
