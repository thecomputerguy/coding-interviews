import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {
    
    private static List<String> findLetterCaseStringPermutations(String input){
        List<String> permutations = new ArrayList<String>();
        if(input == null || input.length() == 0) return permutations;
        permutations.add(input);
        for (int i = 0; i < input.length(); i++) {
            if(Character.isLetter(input.charAt(i))){

                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chars = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    }else{
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    permutations.add(String.valueOf(chars));
                }           
        }
        }

        return permutations;
    }

    public static void main(String[] args) {
        
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
