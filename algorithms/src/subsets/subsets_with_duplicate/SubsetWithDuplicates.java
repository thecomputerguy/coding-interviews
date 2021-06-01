import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
    
    public static List<List<Integer>> findSubsets(int[] input){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(input == null || input.length == 0) return result;
        Arrays.sort(input);
        int start = 0; int end = 0;
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < input.length; i++) {
            start = 0;
            if (i > 0 && input[i] == input[i-1]) {
                start = end + 1;
            }
            end = result.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> set = result.get(j);
                List<Integer> subset = new ArrayList<Integer>(set);
                subset.add(input[i]);
                result.add(subset);                
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
