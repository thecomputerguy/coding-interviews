import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] numbers, int K){
        List<Integer> missingNumbers = new ArrayList<>();
        if(numbers == null || numbers.length == 0) return missingNumbers;
        int i = 0;
        while (i < numbers.length) {
            if(numbers[i] > 0 && numbers[i] <= numbers.length && numbers[i] != numbers[numbers[i]-1]){
                swap(numbers, i, numbers[i] - 1);
            }else{
                i++;
            }
        }

        Set<Integer> extraNumbers = new HashSet<>(); 
        for (int j = 0; j < numbers.length && missingNumbers.size() < K; j++) {
            if(numbers[j] != j+1){
                missingNumbers.add(j+1);
                extraNumbers.add(numbers[j]);
            }
        }

        for (int j = 1; missingNumbers.size() < K; j++) {
            int candidateNumber = j + numbers.length;
            if (!extraNumbers.contains(candidateNumber)) {
                missingNumbers.add(candidateNumber);
            }
        }

        return missingNumbers;
    }

    private static void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);

    }
}
