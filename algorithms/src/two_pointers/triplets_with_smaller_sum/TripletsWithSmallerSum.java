import java.util.Arrays;

public class TripletsWithSmallerSum {
    
    public static int searchTriplets(int[] input, int targetSum){
        if(input == null || input.length == 0) return 0;
        Arrays.sort(input);
        int count = 0;
        for(int i = 0; i < input.length-2; i++){
            int currentCount = searchPair(input, targetSum-input[i], i);
            count += currentCount;
        }

        return count;
    }

    private static int searchPair(int[] array, int target, int firstIndex){
        int left = firstIndex + 1; int right = array.length - 1;
        int count = 0;
        while(left < right){
            int currentSum = array[left] + array[right];
            if (currentSum < target) {
                count += right - left;
                left++;
            }else{
                right--;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(TripletsWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletsWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
