import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
    }

}

public class RightSideViewBinaryTree {
    
    public static List<TreeNode> traverse(TreeNode root){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int i = 0;
            while (i < levelSize) {
                TreeNode current = queue.poll();
                if(i == levelSize-1){
                    result.add(current);
                }
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                i++;
            }            
        }

        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightSideViewBinaryTree.traverse(root);
        for (TreeNode node : result) {
        System.out.print(node.value + " ");
        }
    }
}
