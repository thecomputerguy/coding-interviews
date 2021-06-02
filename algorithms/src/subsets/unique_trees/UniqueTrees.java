import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class UniqueTrees {
    
    private static List<TreeNode> findUniqueTrees(int num){
        List<TreeNode> uniqueTrees = new ArrayList<>();
        if(num <= 0) return uniqueTrees;

        return findUniqueTreesRecursive(1, num);
    }


    private static List<TreeNode> findUniqueTreesRecursive(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        //Go through each number and make that as the root of the tree.
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = findUniqueTreesRecursive(start, i-1);
            List<TreeNode> rightTree = findUniqueTreesRecursive(i+1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);                    
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
        System.out.println();
        List<TreeNode> result1 = UniqueTrees.findUniqueTrees(3);
        System.out.print("Total trees: " + result1.size());
    }
}
