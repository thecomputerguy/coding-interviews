import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KClosestNumbersAlternateSolutionUsingTwoPointers {

    private static List<Integer> findClosestElements(int[] array, int K, int X){
        List<Integer> result = new LinkedList<Integer>();
        int closestIndex = binarySearch(array, X);
        int left = closestIndex;
        int right = closestIndex + 1;
        
        for(int i = 0; i < K; i++) {

            if (left >= 0 && right < array.length) {
                int diff1 = Math.abs(X - array[left]);
                int diff2 = Math.abs(X - array[right]);
                if(diff1 <= diff2){
                    result.add(0, array[left--]);
                }else{
                    result.add(array[right++]);
                }
            }else if(left >= 0){
                result.add(0, array[left--]);
            }else if(right < array.length){
                result.add(array[right++]);
            }
        }

        return result;
    }

    private static int binarySearch(int[] array, int X){
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if(array[mid] == X) {
                return mid;
            }

            if(X > array[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        if(left > 0) return left - 1;

        return left;

    }

    
    public static void main(String[] args) {
        
        List<Integer> result = KClosestNumbersAlternateSolutionUsingTwoPointers.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestNumbersAlternateSolutionUsingTwoPointers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestNumbersAlternateSolutionUsingTwoPointers.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
