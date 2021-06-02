public class CeilingOfNumber {
    public static int searchCeilingOfANumber(int[] arr, int key) {
        if(arr == null || arr.length == 0) return -1;
        if(key > arr[arr.length-1]) return -1;
        int start = 0; int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == key) return mid;

            if (key < arr[mid]) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }    
        return start;
  }

  public static void main(String[] args) {
    System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
    System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
    System.out.println(CeilingOfNumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}
