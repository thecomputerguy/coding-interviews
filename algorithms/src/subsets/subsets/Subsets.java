import java.util.ArrayList;
import java.util.List;

public class Subsets {
    
    public static List<List<Integer>> findSubsets(int[] input){
        List<List<Integer>> result = new ArrayList<>();
        if(input == null || input.length == 0) return result;

        //Start with empty set.
        result.add(new ArrayList<>());
        //go through each element and add it to all the existing subsets.
        for (int i = 0; i < input.length; i++) {
            int currentElement = input[i];
            int size = result.size();
            for (int j = 0; j < size; j++) {
               List<Integer> set = new ArrayList<>(result.get(j));
                set.add(currentElement);
                result.add(set);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
