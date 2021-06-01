import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    
    private static List<List<Integer>> findPermutations(int[] input){
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(input == null || input.length == 0) return result;
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int i = 0; i < input.length; i++) {
            int n = permutations.size();
            for (int j = 0; j < n; j++) {
                List<Integer> oldPermutation = permutations.poll();
                for (int k = 0; k <= oldPermutation.size(); k++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(k, input[i]);
                    if(newPermutation.size() == input.length){
                        result.add(newPermutation);
                    }else{
                        permutations.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
