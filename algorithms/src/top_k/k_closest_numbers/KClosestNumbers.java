import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Entry {
    int key;
    int value;
    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class KClosestNumbers {
    
    private static List<Integer> findClosestElements(int[] array, int K, int X){
        List<Integer> result = new ArrayList<>();
        int closestToX =  binarySearch(array, X);
        int low = closestToX - K;
        int high = closestToX + K;
        if(low < 0) low = 0;
        if(high > array.length - 1) high = array.length - 1;
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.key, b.key));
        while (low <= high){
            minHeap.offer(new Entry(Math.abs(array[low] - X), low));
            low++;
        }

        int i = 0;
        while(i < K){
            result.add(array[minHeap.poll().value]);
            i++;
        }

        Collections.sort(result);
        return result;
    }

    private static int binarySearch(int[] array, int X) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if(array[mid] == X){
                return mid;
            }

            if(X > array[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        if(low > 0){
            return low - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        
        List<Integer> result = KClosestNumbers.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestNumbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestNumbers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);

    }
}
