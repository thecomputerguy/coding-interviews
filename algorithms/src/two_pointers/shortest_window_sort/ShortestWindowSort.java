public class ShortestWindowSort {

    public static int sort(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }   

        //Find start and end of the out of order elements window
        int left = 0; int right = array.length - 1;
        while(left < right && array[left] <= array[left+1]){
            left++;
        }

        if(left == array.length - 1){
            return 0;
        }

        while (right > 0 && array[right] >= array[right-1]) {
            right--;
        }

        //We have found start and end of the out of order elements.
        //Find the minimum and the maximum of the unordered part
        int i = left;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //find min and max of unsorted part
        while(i <= right){
            max = Math.max(array[i], max);
            min = Math.min(array[i], min);
            i++;
        }

        //Find minimum element index
        while(left > 0 && array[left-1] > min){
            
            left--;
        }
        while (right < array.length-1 && array[right+1] < max) {
            right++;           
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}

