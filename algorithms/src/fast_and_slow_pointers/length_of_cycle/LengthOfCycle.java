public class LengthOfCycle {
    
    public static int findCycleLength(ListNode head){
        if(head == null) return 0;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //has a cycle. calculate length of a cycle.
              int length =  cycleLength(slow);
              return length;
            }
        }

        return 0;
    }

    private static int cycleLength(ListNode slow){
        int length = 0;
        ListNode current = slow;
       do{
            current = current.next;
            length++;
       }
        while(current != slow);
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LengthOfCycle.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LengthOfCycle.findCycleLength(head));
    }
}


class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}