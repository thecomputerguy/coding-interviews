public class BinarySearchIterative {

    public static int binSearch(int[] array, int element){
        if(array == null || array.length == 0) return -1;
        return binSearch(array, element, 0, array.length - 1);
    }

    private static int binSearch(int[] array, int element, int start, int end){

        while(start <= end){
            int mid = start + (end - start)/2;
            if(array[mid] == element){
                return mid;
            }else if(array[mid] < element){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        int[] inputs = {10, 49, 99, 110, 176};

        for (int i = 0; i < inputs.length; i++) { 
        System.out.println("binSearch(arr, " + inputs[i]+ ") = " +  BinarySearchIterative.binSearch(arr, inputs[i]));
        }
    }
}
