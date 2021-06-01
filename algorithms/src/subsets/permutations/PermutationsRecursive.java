import java.util.ArrayList;
import java.util.List;

public class PermutationsRecursive {
    
    public static List<List<Integer>> generatePermutations(int[] input){
        List<List<Integer>> result = new ArrayList<>();
        if(input == null || input.length == 0) return result;

        generatePermutationsRecursive(input, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] input, int currentIndex, List<Integer> currentPermutation, List<List<Integer>> result){

        if(currentIndex == input.length){
            result.add(currentPermutation);
        }else{
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(i, input[currentIndex]);
                generatePermutationsRecursive(input, currentIndex+1, newPermutation, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsRecursive.generatePermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
