import java.util.ArrayList;
import java.util.List;

public class AllDuplicateNumbers {
    
    public static List<Integer> findNumbers(int[] numbers){
        List<Integer> result = new ArrayList<>();        
        if(numbers == null || numbers.length == 0) return result;
        int i = 0;
        while (i < numbers.length) {
            if(numbers[i] != numbers[numbers[i] - 1]){
                swap(numbers, i, numbers[i] - 1);
            }else{
                i++;
            }
        }

        //Go through all the elements in the numbers array and find the numbers that are not at their correct position
        for (int j = 0; j < numbers.length; j++) {
            if (numbers[j] != j+1) {
                result.add(numbers[j]);                
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
         List<Integer> duplicates = AllDuplicateNumbers.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = AllDuplicateNumbers.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
