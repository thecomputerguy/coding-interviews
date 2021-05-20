import java.util.Arrays;

public class TripletSumCloseToTarget {
    

    public static int searchTriplet(int[] array, int target){   
        if(array == null || array.length < 3) throw new IllegalArgumentException();
        Arrays.sort(array);
        int smallestDifference = Integer.MAX_VALUE;
        for(int i = 0; i < array.length-2; i++){
            int left = i + 1; int right = array.length - 1;
            while(left < right){
                int targetDiff = target - array[i] - array[left] - array[right];
                if(targetDiff == 0){
                    return target-targetDiff;
                }

                if(Math.abs(targetDiff) < Math.abs(smallestDifference) || Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference){
                    smallestDifference = targetDiff;
                }

                if(targetDiff > 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        return target - smallestDifference;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));    
    }
}
