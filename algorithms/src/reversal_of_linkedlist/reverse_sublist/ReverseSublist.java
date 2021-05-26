class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}

public class ReverseSublist {
    
    public static ListNode reverse(ListNode head, int p, int q){
        if(head == null || p == q) return head;
        //skip p-1 nodes
        
        ListNode current = head;
        ListNode previous = null;
        int i = 1;
        while(current != null && i <= p - 1) {
            previous = current;
            current = current.next;
            i++;
        }

        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSublist = current;
        //Reverse nodes from p to q
        int j = 0;
        while(current != null && j < q - p + 1){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            j++;
        }

        
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;            
        }else{
            head = previous;
        }

        lastNodeOfSublist.next = current;

        return head;
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSublist.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
        System.out.print(result.value + " ");
        result = result.next;
        }
    }
}
