import java.util.Arrays;

public class MoveAllZerosToTheBeginning {
    
    public static void moveZerosToLeft(int[] arr){
        if(arr == null || arr.length == 0) return;

        int readPointer = arr.length - 1;
        int writePointer = arr.length - 1;
        while (readPointer > -1) {
            if(arr[readPointer] != 0){
                arr[writePointer] = arr[readPointer];
                writePointer--;
            }
            readPointer--;
        }

        while (writePointer >= 0) {
            arr[writePointer] = 0;
            writePointer--;
        }
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));
    
        moveZerosToLeft(v);
    
        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }
}
