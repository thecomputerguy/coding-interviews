import java.util.ArrayList;
import java.util.List;

public class PathWithMaximumSum {
    private static int maximumSum = Integer.MIN_VALUE;
    private static List<Integer> pathWithMaxSum = new ArrayList<Integer>();

    public static List<Integer> findPathWithMaximumSum(TreeNode root){
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathWithMaximumSumRecursive(root, currentPath, 0);
        return pathWithMaxSum;
    }

    private static void findPathWithMaximumSumRecursive(TreeNode currentNode, List<Integer> currentPath, int currentSum){

        if(currentNode == null) return;

        currentSum += currentNode.value;
        currentPath.add(currentNode.value);
        if(currentNode.left == null && currentNode.right == null){
            if(currentSum > maximumSum){
                maximumSum = currentSum;
                pathWithMaxSum = new ArrayList<Integer>(currentPath);
            }
        }else{
            findPathWithMaximumSumRecursive(currentNode.left, currentPath, currentSum);
            findPathWithMaximumSumRecursive(currentNode.right, currentPath, currentSum);
        }

        currentPath.remove(currentPath.size() - 1);
        currentSum -= currentNode.value;
        
    }

    public static void main(String[] args) {
        
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(4);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            List<Integer> result = PathWithMaximumSum.findPathWithMaximumSum(root);
            System.out.println("Tree paths with sum " + maximumSum + ": " + result);
    }
}
