package equal_subset_sum_partition;

public class PartitionSet {
    
    public boolean canPartition(int[] nums){
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        return canPartitionRecursive(nums, sum / 2, 0);
    }

    private boolean canPartitionRecursive(int[] nums, int sum, int currentIndex){

        if(sum == 0) return true;
        if(currentIndex >= nums.length) return false;

        if(nums[currentIndex] <= sum){
            if(canPartitionRecursive(nums, sum - nums[currentIndex], currentIndex + 1)){
                return true;
            }
        }

        return canPartitionRecursive(nums, sum, currentIndex + 1);

    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}
