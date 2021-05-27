import java.util.LinkedList;
import java.util.Queue;

class TreeNodeWithNextPointer{
    int value;
    TreeNodeWithNextPointer left, right, next;
    public TreeNodeWithNextPointer(int value){
        this.value = value;
    }
}

public class ConnectAllLevelOrderSibling {

    public static void connect(TreeNodeWithNextPointer root){
        if(root == null) return;
        Queue<TreeNodeWithNextPointer> queue = new LinkedList<>();
        queue.add(root);
        TreeNodeWithNextPointer previous = null;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int i = 0;
            while(i < levelSize){
                
                TreeNodeWithNextPointer current = queue.poll();
                if(previous != null){
                    previous.next = current;
                }
                previous = current;
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);

                i++;
            }
        }
    }
    
    public static void main(String[] args) {
        
        TreeNodeWithNextPointer root = new TreeNodeWithNextPointer(12);
        root.left = new TreeNodeWithNextPointer(7);
        root.right = new TreeNodeWithNextPointer(1);
        root.left.left = new TreeNodeWithNextPointer(9);
        root.right.left = new TreeNodeWithNextPointer(10);
        root.right.right = new TreeNodeWithNextPointer(5);
        ConnectAllLevelOrderSibling.connect(root);

        // level order traversal using 'next' pointer
        TreeNodeWithNextPointer current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
        System.out.print(current.value + " ");
        current = current.next;
        }
    }
}
