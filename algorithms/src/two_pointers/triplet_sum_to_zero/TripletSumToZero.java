import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    
    public static List<List<Integer>> searchTriplets(int[] array){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    if(array == null || array.length == 0) return result;    
        //Sort array
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if(i > 0 && array[i] == array[i - 1]){
                continue;
            }
            searchPair(array, -array[i], i, result);
        }

        return result;
    }

    private static void searchPair(int[] array, int targetSum, int index, List<List<Integer>> result){
        int left = index + 1; int right = array.length-1;

        while(left < right){
            int currentSum = array[left] + array[right];
            if(currentSum == targetSum){
                result.add(Arrays.asList(array[index], array[left], array[right]));
                left++;
                right--;
            while(left < right && array[left]  == array[left-1])
            left++;
            while(left < right && array[right] == array[right+1])
            right--;
            }else if(currentSum < targetSum){
                left++;
            }else{
                right--;
            }
        }
    }

    public static void main(String[] args) {
         System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
    System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
