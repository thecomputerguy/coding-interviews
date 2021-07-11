import java.util.Arrays;

public class PairSum {
    
    public static boolean findSumOfTwo(int[] arr, int sum){
        if(arr == null || arr.length == 0 || arr.length == 1){
            return false;
        }
        
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int currentSum = arr[left] + arr[right];
            if(currentSum == sum){
                return true;
            }else if(currentSum < sum){
                left++;
            }else{
                right--;
            }
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
