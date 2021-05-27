import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class FindAllTreePaths {
    
    public static List<List<Integer>> findPaths(TreeNode root, int sum){
        List<Integer> currentPath = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<>();
        findPathsRecursive(root, sum, currentPath, result);
        return result;
    }


    private static void findPathsRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> result){
        if(root == null) return;

        currentPath.add(root.value);
        if(root.value == sum && root.left == null && root.right == null){
            result.add(new ArrayList<Integer>(currentPath));
        }else{
            findPathsRecursive(root.left, sum-root.value, currentPath, result);
            findPathsRecursive(root.right, sum-root.value, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);        
    }


    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
