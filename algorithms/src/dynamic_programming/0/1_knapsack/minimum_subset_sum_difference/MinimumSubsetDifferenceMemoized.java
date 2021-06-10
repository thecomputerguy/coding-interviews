package minimum_subset_sum_difference;

public class MinimumSubsetDifferenceMemoized {
    
    public int canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        return canPartitionRecursive(nums, 0, 0, 0);
    }

    public int canPartitionRecursive(int[] nums, int currentIndex, int sum1, int sum2){

        return 0;
    }

    public static void main(String[] args) {
        MinimumSubsetDifferenceBottomUp ps = new MinimumSubsetDifferenceBottomUp();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
