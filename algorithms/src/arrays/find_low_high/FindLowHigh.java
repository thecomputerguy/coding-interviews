import java.util.Arrays;
import java.util.List;

public class FindLowHigh {

    public static int findLowIndex(int[] arr, int key){
        int keyIndex = -1;
        if(arr == null || arr.length == 0){
            return keyIndex;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == key){
                keyIndex = mid;
                end = mid - 1;
            }else if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return keyIndex;
    }

    public static int findHighIndex(int[] arr, int key){
        int keyIndex = -1;
        if(arr == null || arr.length == 0){
            return keyIndex;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == key){
                keyIndex = mid;
                start = mid + 1;
            }else if(key > arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return keyIndex;
    }
    
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4,4, 5, 5, 5, 6, 6, 6, 6, 6, 6};
        int key = 5;
        int low = findLowIndex(array, key);
        int high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = 6;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
    }
}
