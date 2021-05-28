import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class TreeNode{
    int value;
    TreeNode left, right;
    public TreeNode(int value){
        this.value = value;
    }
}

public class CountAllPathSum {
    
    private static int countPaths(TreeNode root, int S){
        if (root == null) {
            return 0;
        }
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath){
        if(currentNode == null) return 0;

        currentPath.add(currentNode.value);
        int pathSum = 0; int pathCount = 0;
        ListIterator<Integer> iter = currentPath.listIterator(currentPath.size());
        while (iter.hasPrevious()){
            pathSum += iter.previous();
            if (pathSum == S) {
                pathCount++;
            }
        }

        pathCount += countPathsRecursive(currentNode.left, S, currentPath);
        pathCount += countPathsRecursive(currentNode.right, S, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
