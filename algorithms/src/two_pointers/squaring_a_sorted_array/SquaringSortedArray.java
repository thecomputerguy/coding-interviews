public class SquaringSortedArray {
   

    public static int[] makeSquares(int[] array){
        int[] result = new int[array.length];
        if(array == null || array.length == 0) return result; 
        int left = 0;
        int right = array.length - 1;
        int index = array.length - 1;
        while (left <= right) {
            int leftElementSquared = array[left] * array[left];
            int rightElementSquared = array[right] * array[right];
            if(leftElementSquared > rightElementSquared){
                result[index] = leftElementSquared;
                left++;
            }else{
                result[index] = rightElementSquared;
                right--;
            }
            index--;           
        }

        return result;
    }


    public static void main(String[] args) {
 
    int[] result = SquaringSortedArray.makeSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = SquaringSortedArray.makeSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();
 
    }
     
}
