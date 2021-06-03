public class BitonicArray {

    public static int findMax(int[] array){
        if(array == null || array.length == 0) return -1;

        int start = 0; int end = array.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            boolean ascending = false;
            if(array[mid] > array[mid + 1]){
                ascending = false;
            }else if(array[mid] < array[mid + 1]){
                ascending = true;
            }

            if(ascending){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        //both start and end are gonna point to max number in the array.
        //We can use either start or end to return the max number.
        return array[start];
    }
    
    public static void main(String[] args) {
        
         System.out.println(BitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(BitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(BitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(BitonicArray.findMax(new int[] { 10, 9, 8 }));
    }
}
