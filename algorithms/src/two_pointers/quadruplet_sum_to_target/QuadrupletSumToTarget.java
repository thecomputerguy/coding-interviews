import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupletSumToTarget{


    public static List<List<Integer>> searchQuadruplets(int[] array, int targetSum){
        
        List<List<Integer>> result = new ArrayList<>();
        if(array == null || array.length == 0) return result;
        Arrays.sort(array);
        for(int i = 0; i < array.length-3; i++){
            if(i > 0 && array[i] == array[i-1])
                continue;
            for (int j = i+1; j < array.length-2; j++) {
                if (j > 1 && array[j] == array[j-1]) {
                    continue;
                }
                int left = j + 1, right = array.length-1;
                while(left < right){
                    int currentSum = array[i] + array[j] + array[left] + array[right];
                    if(currentSum == targetSum){
                        result.add(Arrays.asList(array[i], array[j], array[left], array[right]));
                        left++;
                        right--;
                        while (left < right && array[left] == array[left-1]){
                            left++;
                        }
                        while (left < right && array[right] == array[right+1]) {
                            right--;
                        }
                    }else if(currentSum < targetSum){
                        left++;
                    }else{
                        right--;
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(QuadrupletSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
        System.out.println(QuadrupletSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));
    }
}