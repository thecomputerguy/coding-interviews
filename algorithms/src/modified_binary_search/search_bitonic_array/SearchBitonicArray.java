class SearchBitonicArray {

  public static int search(int[] arr, int key) {
    if(arr == null || arr.length == 0) return -1;
    int maxIndex = findMaxIndex(arr);
    int result = binarySearch(arr, key, 0, maxIndex);
    if(result == -1){
      result = binarySearch(arr, key, maxIndex + 1, arr.length-1);
    }
    return result;
  }


  private static int binarySearch(int[] arr, int key, int start, int end) {

    while(start <= end){
      int mid = start + (end - start) / 2;
      if (arr[mid] == key) {
        return mid;        
      }

      if(arr[start] < arr[end]){
        if(key < arr[mid]){
          end = mid - 1;
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

  private static int findMaxIndex(int[] array){
    int start = 0; int end = array.length - 1;

    while(start < end){
      int mid = start + (end - start) / 2;
      if(array[mid] > array[mid + 1]){
        end = mid;
      }else{
        start = mid + 1;
      }
    }

    return start;
  }

  public static void main(String[] args) {
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
    System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
    System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
    System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
  }
}