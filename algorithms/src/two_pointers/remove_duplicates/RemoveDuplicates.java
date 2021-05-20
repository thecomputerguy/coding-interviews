public class RemoveDuplicates {
    
    public static int remove(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }

        int nextNonDuplicate = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] != array[nextNonDuplicate - 1]){
                array[nextNonDuplicate] = array[i];
                nextNonDuplicate++;
            }
        }
        
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(RemoveDuplicates.remove(arr));
    }
}
