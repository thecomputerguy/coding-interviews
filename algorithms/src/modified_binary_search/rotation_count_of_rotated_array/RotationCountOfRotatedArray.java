class RotationCountOfRotatedArray {

  public static int countRotations(int[] arr) {
    int start = 0;
    int end = arr.length - 1;

    while(start <= end){
        int mid = start + (end - start) / 2;

        if(mid < end && arr[mid] > arr[mid + 1]){
            return mid + 1;
        }

        if(mid > start && arr[mid - 1] > arr[mid]){
            return mid;
        }

        if(arr[start] < arr[mid]){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
    }
    return 0; 
  }

  public static void main(String[] args) {
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
  }
}
