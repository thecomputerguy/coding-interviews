import java.util.*;

class ArrayElement{
  int arrayIndex;
  int elementIndex;

  public ArrayElement(int elementIndex, int arrayIndex){
    this.arrayIndex = arrayIndex;
    this.elementIndex = elementIndex;
  }
}

class KthSmallestInMSortedArrays {

  public static int findKthSmallest(List<Integer[]> lists, int k) {
    
    if(lists == null || lists.size() == 0 || k <= 0) return -1;
    PriorityQueue<ArrayElement> minHeap = new PriorityQueue<>((a, b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);
    
    // put the 1st element of each array in the min heap
    for (int i = 0; i < lists.size(); i++)
      if (lists.get(i) != null)
        minHeap.add(new ArrayElement(0, i));

    
    int count = 0; int result = 0;
    while (!minHeap.isEmpty()) {
      ArrayElement element = minHeap.poll();
      
      result = lists.get(element.arrayIndex)[element.elementIndex];
      count++;
      if(count == k){
        break;
      }
      element.elementIndex++;
      if (lists.get(element.arrayIndex).length > element.elementIndex) {
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
    int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}
