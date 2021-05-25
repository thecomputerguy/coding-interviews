import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {
    
    public static List<Integer> findNumbers(int[] numbers){
        List<Integer> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) return result;
        int i = 0;
        while (i < numbers.length) {
            int j = numbers[i] - 1;
            if (numbers[i] != numbers[j]) {
                swap(numbers, i, j);
            }else{
                i++;
            }
        }

        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] != j+1) {
                result.add(j+1);
            }
        }

        return result;
    }


    private static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
