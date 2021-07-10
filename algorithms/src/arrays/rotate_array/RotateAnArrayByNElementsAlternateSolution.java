import java.util.Arrays;

public class RotateAnArrayByNElementsAlternateSolution {
    
    public static final void rotateArray(int[] arr, int rotations){
        if(arr == null || arr.length == 0){
            return;
        }
        
        int n = rotations % arr.length;
        if(n < 0){
            n = arr.length + n;
        }

        int[] newArray = new int[n];
        // copy n to arr.length - 1 elements in the new array.
        for (int i = 0; i < n; i++) {
            newArray[i] = arr[arr.length - n + i]; //10 - 7 + i
        }

        //shift remaining elements to the right.
        //len - n = remaining elements
        int i = arr.length - n - 1; int k = arr.length - 1;
        while (i >= 0) {
             arr[k] = arr[i];
            i--;
            k--;
        }
        
        //copy back arr.length - n elements to the original array in the beginning
        for (int j = 0; j < newArray.length; j++) {
            arr[j] = newArray[j];
        }
    }

    public static void main(String[] args) {
        
        int[] arr =  new int[]{1, 10, 20, 0, 59, 86, 32, 11, 9, 40};
        System.out.println("Array Before Rotation\n"+ Arrays.toString(arr));
        RotateAnArrayByNElementsAlternateSolution.rotateArray(arr, 2);
        System.out.println("Array After Rotation\n"+ Arrays.toString(arr));
    }
}
