public class RemoveAllInstancesOfKey {
    
    public static int remove(int[] array, int key){

        if(array == null || array.length == 0) return -1;
        int nextIndex = 0;
        for(int i = 0; i < array.length; i++){

            if(array[i] != key){
                array[nextIndex] = array[i];
                nextIndex++;
            }
        }

        return nextIndex;
    }


    public static void main(String[] args) {
    int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
    System.out.println(RemoveAllInstancesOfKey.remove(arr, 3));

    arr = new int[] { 2, 11, 2, 2, 1 };
    System.out.println(RemoveAllInstancesOfKey.remove(arr, 2));
  }
}
