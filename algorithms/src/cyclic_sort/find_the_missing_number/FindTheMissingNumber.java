public class FindTheMissingNumber {
    
    public static int findMissingNumber(int[] numbers){
        if(numbers == null || numbers.length == 0) return -1;
        int i = 0;
        while (i < numbers.length) {
            
            if(numbers[i] < numbers.length && numbers[i] != numbers[numbers[i]]){
                swap(numbers, i, numbers[i]);
            }else{
                i++;
            }
        }

        int j = 0;
        for (;j < numbers.length; j++) {
            if (numbers[j] != j) {
                return j;
            }
        }

        return numbers.length;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(FindTheMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
