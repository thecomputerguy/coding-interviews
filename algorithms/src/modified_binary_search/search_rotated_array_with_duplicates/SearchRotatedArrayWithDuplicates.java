public class SearchRotatedArrayWithDuplicates {
    
    public static int search(int[] array, int key){

        int start = 0;
        int end = array.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(array[mid] == key) return mid;

            if(array[mid] == array[start] && array[mid] == array[end]){
                start++;
                end--;
            }else if(array[start] <= array[mid]){

                if(key >= array[start] && key < array[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }

            }else{

                if(key > array[mid] && key <= array[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }

            }
        }

        return -1;
    }


    public static void main(String[] args) {
        
        System.out.println(SearchRotatedArrayWithDuplicates.search(new int[] { 3, 7, 3, 3, 3 }, 7));
    }
}
