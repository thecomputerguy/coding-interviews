import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class RootToLeafPaths {
    

    public static List<List<Integer>> findPaths(TreeNode root){
        List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths){

        if(currentNode == null) return;

        currentPath.add(currentNode.value);
        if(currentNode.left == null && currentNode.right == null){
            allPaths.add(new ArrayList<Integer>(currentPath));
        }else{
            findPathsRecursive(currentNode.left, currentPath, allPaths);
            findPathsRecursive(currentNode.right, currentPath, allPaths);
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
            List<List<Integer>> result = RootToLeafPaths.findPaths(root);
            System.out.println("Tree paths with sum " + ": " + result);
    }
}
