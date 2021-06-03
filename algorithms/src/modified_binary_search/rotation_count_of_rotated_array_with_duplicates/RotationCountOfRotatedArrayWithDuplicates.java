public class RotationCountOfRotatedArrayWithDuplicates {
   
    public static int countRotations(int[] array){
        if(array == null || array.length == 0) return 0;
        int start = 0;
        int end = array.length - 1;

        while(start <= end){
                int mid = start + (end - start) / 2;

                if(mid < end && array[mid] > array[mid + 1]){
                    return mid + 1;
                }

                if(mid > start && array[mid - 1] > array[mid]){
                    return mid;
                }

                if(array[mid] == array[start] && array[mid] == array[end]){

                    if(array[start] > array[start + 1]){
                        return start + 1;
                    }
                    start++;

                    if(array[end] < array[end - 1]){
                        return end;
                    }
                    end--;
                }else if(array[start] < array[mid] || (array[start] == array[mid] && array[mid] > array[end])){
                        start = mid + 1;
                }else{
                        end = mid - 1;
                }
                
        }

        return 0;
    }
    
   public static void main(String[] args) {
    System.out.println(RotationCountOfRotatedArrayWithDuplicates.countRotations(new int[] { 3, 3, 7, 3 }));
  }
}
