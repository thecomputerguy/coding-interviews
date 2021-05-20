import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarraySumLessThanTarget {
    
    public static List<List<Integer>> findSubarrays(int[] array, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(array == null || array.length == 0) return result;

        double prod = 1; int left = 0;
        for (int right = 0; right < array.length; right++) {
            prod *= array[right];

            while (prod >= targetSum && left < array.length) {
                prod /= array[left++];                
            }
            List<Integer> subarray = new LinkedList<Integer>();
            for (int j = right; j >= left ; j--) {
                subarray.add(0, array[j]);
                result.add(new ArrayList<Integer>(subarray));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        System.out.println(SubarraySumLessThanTarget.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarraySumLessThanTarget.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
  
    }
}
