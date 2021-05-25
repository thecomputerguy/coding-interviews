public class CyclicSort {

    public static int[] sort(int[] array){

        if(array == null || array.length == 0) return array;
        int i = 0;
        while (i < array.length) {
            int j = array[i] - 1;
            if(array[i] != array[j]){
                swap(array, i, j);
            }else{
                i++;
            }
        }

        return array;
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
        System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
        System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
        System.out.print(num + " ");
        System.out.println();
    }
}
