import java.util.Arrays;
import java.util.List;

public class RotateAnArrayByNElements {
    
    public static void rotateArray(int[] arr, int rotations){
            if(arr == null || arr.length == 0 || rotations == 0 || Math.abs(rotations) == arr.length) return;
            int n = rotations % arr.length;
            //convert left rotations to right rotations
            if(n < 0){
                n = arr.length + n;
            }
            //Reverse complete array
            reverseArray(arr, 0, arr.length - 1);
            //Reverse 0 - n-1
            reverseArray(arr, 0, n - 1);
            //Reverse n - len - 1
            reverseArray(arr, n, arr.length - 1);
    
    }

    private static void reverseArray(int[] arr, int start, int end){
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1, 10, 20, 0, 59, 86, 32, 11, 9, 40};
        System.out.println("Array Before Rotation\n"+ Arrays.toString(arr));
        RotateAnArrayByNElements.rotateArray(arr, 2);
        System.out.println("Array After Rotation\n"+ Arrays.toString(arr));
    }
}
