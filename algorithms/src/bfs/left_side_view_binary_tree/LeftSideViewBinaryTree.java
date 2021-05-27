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
public class LeftSideViewBinaryTree {
    
    public static List<TreeNode> traverse(TreeNode root){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(i == 0){
                    result.add(current);
                }
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);                
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
        List<TreeNode> result = LeftSideViewBinaryTree.traverse(root);
        for (TreeNode node : result) {
        System.out.print(node.value + " ");
        }
    }
}
