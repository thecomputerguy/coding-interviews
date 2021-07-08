public class SearchRotatedArrayRecursive {
    
    public static int binarySearchRotated(int[] arr, int element){
        if(arr == null || arr.length == 0) return -1;
        return binarySearchRotated(arr, element, 0, arr.length - 1);
    }

    private static int binarySearchRotated(int[] arr, int element, int start, int end){
        int mid = start + (end - start) / 2;

        if(arr[mid] == element) return mid;
        if(arr[start] <= arr[mid] && element <= arr[mid] && element >= arr[start]){
            return binarySearchRotated(arr, element, start, mid - 1);
        }else if(arr[mid] <= arr[end] && element >= arr[mid] && element <= arr[end]){
            return binarySearchRotated(arr, element, mid + 1, end);
        }else if(arr[start] >= arr[mid]){
            return binarySearchRotated(arr, element, start, mid - 1);
        }else if(arr[mid] >= arr[end]){
            return binarySearchRotated(arr, element, mid + 1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
            int[] v1 = {6, 7, 1, 2, 3, 4, 5};
            System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
            System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));
            
            int[] v2 = {4, 5, 6, 1, 2, 3};
            System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
            System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));    
    }
}
