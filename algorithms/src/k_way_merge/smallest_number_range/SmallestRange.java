import java.util.*;

class Holder{
  int arrayIndex;
  int elementIndex;

  public Holder(int arrayIndex, int elementIndex){
    this.arrayIndex = arrayIndex;
    this.elementIndex = elementIndex;
  }
}

class SmallestRange {

  public static int[] findSmallestRange(List<Integer[]> lists) {
    if(lists == null || lists.size() == 0) return new int[]{-1, -1};
    PriorityQueue<Holder> minHeap = new PriorityQueue<Holder>((a, b) -> lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]);
    int maximumValue = Integer.MIN_VALUE;
    for (int i = 0; i < lists.size(); i++) {
      if(lists.get(i) != null){
        minHeap.offer(new Holder(i, 0));
        maximumValue = Math.max(maximumValue, lists.get(i)[0]);
      }
    }

    int rangeStart = 0; int rangeEnd = Integer.MAX_VALUE;
    while (minHeap.size() == lists.size()) {
      Holder element = minHeap.poll();
      if(rangeEnd - rangeStart > maximumValue - lists.get(element.arrayIndex)[element.elementIndex]){
        rangeStart = lists.get(element.arrayIndex)[element.elementIndex];
        rangeEnd = maximumValue;
      }

      element.elementIndex++;
      if (lists.get(element.arrayIndex).length > element.elementIndex) {
        minHeap.offer(element);
        maximumValue = Math.max(maximumValue, lists.get(element.arrayIndex)[element.elementIndex]);
      }

    }


    return new int[] { rangeStart, rangeEnd };
  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[] { 1, 5, 8 };
    Integer[] l2 = new Integer[] { 4, 12 };
    Integer[] l3 = new Integer[] { 7, 8, 10 };
    List<Integer[]> lists = new ArrayList<Integer[]>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int[] result = SmallestRange.findSmallestRange(lists);
    System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
  }
}
