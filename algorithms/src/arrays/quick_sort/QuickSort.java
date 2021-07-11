import java.util.Arrays;

public class QuickSort {
    
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 0 || arr.length == 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }   
    }

    private static int partition(int[] arr, int low, int high){
        int i = low;
        int j = high;
        int pivotValue = arr[low];
        while(i < j){

            while ( i < j && arr[i] <= pivotValue) i++;
            while(arr[j] > pivotValue) j--;

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivotValue;
        return j;
    }

    public static void main(String[] args) {
        int[] a = new int[] {55, 23, 26, 2, 18, 78, 23, 8, 2, 3};
    
        System.out.print("Before Sorting\n");
        System.out.print(Arrays.toString(a) + "\n");

        quickSort(a);

        System.out.print("After Sorting\n");
        System.out.print(Arrays.toString(a));
    }
}
