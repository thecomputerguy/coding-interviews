public class DuplicateNumber {
    
    public static int findNumber(int[] numbers){
        if(numbers == null || numbers.length == 0) return -1;

        int i = 0;
        while (i < numbers.length) {
        if (numbers[i] != i+1) {
            int j = numbers[i]-1;
            if(numbers[i] != numbers[j]){
                swap(numbers, i, j);
            }else{
                return numbers[i];
            }
        }else{
                i++;
            }
        }

        return -1;
    }

    public static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        
        System.out.println(DuplicateNumber.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(DuplicateNumber.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(DuplicateNumber.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
