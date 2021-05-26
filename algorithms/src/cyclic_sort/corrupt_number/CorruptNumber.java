public class CorruptNumber {
    
    public static int[] findNumbers(int[] numbers){
        int[] result = new int[]{-1, -1};
        if(numbers == null || numbers.length == 0) return result;

        int i = 0;
        while(i < numbers.length){
            
                if(numbers[i] != numbers[numbers[i] - 1]){
                    
                    swap(numbers, i, numbers[i] - 1);
                
                }else{

                i++;
            }

        }

        for(int j = 0; j < numbers.length; j++){
            if(numbers[j] != j+1){
                return new int[]{numbers[j], j+1};
            }
        }

        return result;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = CorruptNumber.findNumbers(new int[] { 3, 1, 2, 5, 2 });
    System.out.println(nums[0] + ", " + nums[1]);
    nums = CorruptNumber.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
    System.out.println(nums[0] + ", " + nums[1]);
    }
}
