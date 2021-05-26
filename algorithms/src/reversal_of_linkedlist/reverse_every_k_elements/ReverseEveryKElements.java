class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}

public class ReverseEveryKElements {
    
    public static ListNode reverse(ListNode head, int K){
        if (K <= 1) return head;
        if (head == null) return head;
        ListNode current = head; ListNode previous = null;
        
        while (true) {

          ListNode lastNodeOfPreviousPart = previous;  
            ListNode lastNodeOfSubList = current;
          for (int i = 0; current != null && i < K; i++) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
          }
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            }else{
                head = previous;                
            }

            lastNodeOfSubList.next = current;

            if(current == null){

                break;
            }
           
        previous = lastNodeOfSubList;
            
        }

        return head;
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
        System.out.print(result.value + " ");
        result = result.next;
        }
    }
}
