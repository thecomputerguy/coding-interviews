import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow{
    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
      ArrayDeque<Integer> result = new ArrayDeque<>(); 
      Deque<Integer> list = new LinkedList<>();
      if(arr == null || arr.length == 0 || arr.length < windowSize) return result;
      
      for (int windowEnd = 0; windowEnd < windowSize; windowEnd++) {
        if(!list.isEmpty() && arr[windowEnd] >= arr[list.peekLast()]){
          list.removeLast();
        }
        list.addLast(windowEnd);
      }

      for (int windowEnd = windowSize; windowEnd < arr.length; windowEnd++) {
        result.add(arr[list.peekFirst()]);

        while(list.peekFirst() <= windowEnd - windowSize){
          list.removeFirst();
        }

        while (!list.isEmpty() && arr[list.peekLast()] <= arr[windowEnd]) {
          list.removeLast();      
        }

        list.addLast(windowEnd);
      }

      result.add(arr[list.peekFirst()]);
      
      return result; 
    }

    public static void main(String[] args){

       int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("Array = " + Arrays.toString(array));
    System.out.println("Max = " + MaxSlidingWindow.findMaxSlidingWindow(array, 3));
    
    int[] array2 = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
    System.out.println("Array = " + Arrays.toString(array2));
    System.out.println("Max = " + MaxSlidingWindow.findMaxSlidingWindow(array2, 3));     
    }
}
