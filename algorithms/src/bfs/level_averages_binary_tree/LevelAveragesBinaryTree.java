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

public class LevelAveragesBinaryTree {
    

    public static List<Double> findLevelAverages(TreeNode root){
        List<Double> result = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int i = 0;
            Double currentLevelSum = 0.0;
            while (i < levelSize) {
                TreeNode node = queue.poll();
                currentLevelSum += node.value;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                i++;
            }
            result.add(currentLevelSum/levelSize);
        }
        
        return result;
    }

    public static void main(String[] args) {
            TreeNode root = new TreeNode(12);
            root.left = new TreeNode(7);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(9);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(10);
            root.right.right = new TreeNode(5);
            List<Double> result = LevelAveragesBinaryTree.findLevelAverages(root);
            System.out.print("Level averages are: " + result);
    }
}
