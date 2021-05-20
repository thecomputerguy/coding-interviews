import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSumTriplets {
    
    public static List<List<Integer>> searchTriplets(int[] input, int targetSum){
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(input == null || input.length == 0) return result;
        Arrays.sort(input);
        for (int i = 0; i < input.length-2; i++) {
            searchPair(input, targetSum - input[i], i, result);
        }
        return result;
    }

    public static void searchPair(int[] input, int target, int i, List<List<Integer>> result) {
        
        int left = i + 1; int right = input.length - 1;
        while(left < right){
            int currentSum = input[left] + input[right];
            if(currentSum < target){
                for (int j = right; j > left; j--) {
                    result.add(Arrays.asList(input[i], input[left], input[j]));
                }
                left++;
            }else{
                right--;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSumTriplets.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
    System.out.println(TripletWithSmallerSumTriplets.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
  
    }
}
