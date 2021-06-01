import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString{
    String parentheses;
    int openCount;
    int closeCount;

    public ParenthesesString(String parentheses, int openCount, int closeCount) {
        this.parentheses = parentheses;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

public class GenerateParentheses {
    
    private static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<String>();

        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.offer(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString element = queue.poll();
            if (element.openCount == num && element.closeCount == num) {
                result.add(element.parentheses);
            }else{
                if (element.openCount < num) {
                    queue.offer(new ParenthesesString(element.parentheses + "(", element.openCount+1, element.closeCount));
                }

                if(element.closeCount < element.openCount) {
                    queue.offer(new ParenthesesString(element.parentheses + ")", element.openCount, element.closeCount+1));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
