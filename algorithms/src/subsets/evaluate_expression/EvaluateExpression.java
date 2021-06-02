import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EvaluateExpression {

    private static Map<String, List<Integer>> cache = new HashMap<String, List<Integer>>();

  public static List<Integer> diffWaysToEvaluateExpression(String input) {
    List<Integer> result = new ArrayList<>();
    if(cache.containsKey(input)) return cache.get(input);
    if(!input.contains("+") && !input.contains("-") && !input.contains("*")){
        result.add(Integer.parseInt(input));
    }else{
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!Character.isDigit(ch)){
                List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i+1));

                for(int leftPart : leftParts){
                    for(int rightPart : rightParts){
                        if(ch == '+'){  
                            result.add(leftPart + rightPart);
                        }else if(ch == '-'){
                            result.add(leftPart - rightPart);                            
                        }else if(ch == '*'){
                            result.add(leftPart * rightPart);
                        }
                    }
                }
            }
        }
    }
    cache.put(input, result);
    return result;
  }

  public static void main(String[] args) {
    List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
    System.out.println("Expression evaluations: " + result);

    result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
    System.out.println("Expression evaluations: " + result);
  }
}
