public class DutchNationalFlag {

    public static void sort(int[] array){
        if(array == null || array.length == 0) return;
        int left = 0, right = array.length - 1;
        for (int i = 0; i <= right;) {
            if (array[i] == 0) {
                swap(array, i, left);
                i++;
                left++;
            }else if(array[i] == 1){
                i++;
            }
            else{
                swap(array, i, right);
                right--;
            }
        }
    }

    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
    DutchNationalFlag.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();

    arr = new int[] { 2, 2, 0, 1, 2, 0 };
    DutchNationalFlag.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");

    }
}
