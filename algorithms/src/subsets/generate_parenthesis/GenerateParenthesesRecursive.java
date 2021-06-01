import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString{
    String parentheses;
    int openCount;
    int closeCount;

    public ParenthesesString(String parentheses, int openCount, int closeCount){
        this.parentheses = parentheses;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

public class GenerateParenthesesRecursive {
    
    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<String>();
        
        if(num <= 0) return result;
        
        generateValidParenthesesRecursive(num, new ParenthesesString("", 0, 0), result);
        return result;
    }

    private static void generateValidParenthesesRecursive(int num, ParenthesesString parentheses, List<String> result){

        if(parentheses == null) return;

        
        if(parentheses.openCount == num && parentheses.closeCount == num){
            result.add(parentheses.parentheses);
        }else{
            if(parentheses.openCount < num){
                generateValidParenthesesRecursive(num, new ParenthesesString(parentheses.parentheses + "(", parentheses.openCount + 1, parentheses.closeCount), result);
            }

            if(parentheses.closeCount < parentheses.openCount){
                generateValidParenthesesRecursive(num, new ParenthesesString(parentheses.parentheses + ")", parentheses.openCount, parentheses.closeCount+1), result);
            }
        }

    }

    public static void main(String[] args) {
        
        List<String> result = GenerateParenthesesRecursive.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParenthesesRecursive.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
