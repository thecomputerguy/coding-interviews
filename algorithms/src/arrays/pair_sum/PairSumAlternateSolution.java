import java.util.HashSet;
import java.util.Set;

public class PairSumAlternateSolution {

    public static boolean findSumOfTwo(int[] arr, int sum){
        if(arr == null || arr.length == 0 || arr.length == 1){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(sum - arr[i])){
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }
    
    public static void main(String[] args) {
        
        int[] v = new int[] {5, 7, 1, 2, 8, 4, 3};
        int[] test = new int[] {3, 20, 1, 2, 7};
        
        for(int i = 0; i < test.length; i++){
        boolean output = findSumOfTwo(v, test[i]);
        System.out.println("findSumOfTwo(v, " + test[i] + ") = " + (output ? "true" : "false"));
        }
    }
}
