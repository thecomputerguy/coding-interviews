class OrderAgnosticBinarySearch {

  public static int search(int[] arr, int key) {
    if(arr == null || arr.length == 0) return -1;

    int start = 0;
    int end = arr.length - 1;
    boolean ascending = arr[0] < arr[arr.length - 1];
    while (start <= end){

        int mid = start + (end-start) / 2;
        
        if(arr[mid] == key) return mid;

        if(ascending){
            if(key < arr[mid]){
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }else{
            if(key < arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
    }


    return -1;
  }

  public static void main(String[] args) {
    System.out.println(OrderAgnosticBinarySearch.search(new int[] { 4, 6, 10 }, 10));
    System.out.println(OrderAgnosticBinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
    System.out.println(OrderAgnosticBinarySearch.search(new int[] { 10, 6, 4 }, 10));
    System.out.println(OrderAgnosticBinarySearch.search(new int[] { 10, 6, 4 }, 4));
  }
}