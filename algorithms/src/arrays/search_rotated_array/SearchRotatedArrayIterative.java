public class SearchRotatedArrayIterative {
    
    public static int binarySearchRotated(int[] arr, int key){
        if(arr == null || arr.length == 0) return -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == key) return mid;
            if(arr[start] <= arr[mid] && key >= arr[start] && key <= arr[mid]){
                end = mid - 1;
            }else if(arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]){
                start = mid + 1;
            }else if(arr[start] >= arr[mid]){
                end = mid - 1;
            }else if(arr[mid] >= arr[end]){
                start = mid + 1;
            }
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
