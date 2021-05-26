public class SmallestMissingPositiveNumber {
    

    public static int findNumber(int[] numbers){
        if(numbers == null || numbers.length == 0) return -1;
        
        int i = 0;
        while(i < numbers.length){
            if(numbers[i] > 0 && numbers[i] <= numbers.length && numbers[i] != numbers[numbers[i] - 1]){
                swap(numbers, i, numbers[i] - 1);
            }else{
                i++;
            }
        }

        for (int j = 0; j < numbers.length; j++) {
            if(numbers[j] != j+1){
                return j+1;
            }
        }

        return numbers.length + 1;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(SmallestMissingPositiveNumber.findNumber(new int[] { -3, 1, 5, 4, 2 }));
    System.out.println(SmallestMissingPositiveNumber.findNumber(new int[] { 3, -2, 0, 1, 2 }));
    System.out.println(SmallestMissingPositiveNumber.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
