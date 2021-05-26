import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class BinaryTreeLevelOrderTraversal {
    
    public static List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int i = 0;
            List<Integer> currentLevel = new ArrayList<Integer>();
            while (i < levelSize) {
                TreeNode node = queue.poll();

                currentLevel.add(node.value);

                if (node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);

                i++;
            }

            result.add(currentLevel);
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
        List<List<Integer>> result = BinaryTreeLevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
