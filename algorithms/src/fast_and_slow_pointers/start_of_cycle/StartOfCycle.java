class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
     this.data = data;   
    }
}

public class StartOfCycle {
    
    public static ListNode findCycleStart(ListNode head){

        if(head == null) return null;
        int cycleLength = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleLength = findCycleLength(slow);
                break;
            }
        }

        return findStart(head, cycleLength);
    }

    private static ListNode findStart(ListNode head, int cycleLength) {

        //start from head and move pointer 2 cycleLength steps ahead 
                ListNode pointer1 = head;
                ListNode pointer2 = head;
                int i = cycleLength;
                while(i > 0){
                    pointer2 = pointer2.next;
                    i--;
                }

                while (pointer1 != pointer2) {
                    pointer1 = pointer1.next;
                    pointer2 = pointer2.next;                    
                }

                return pointer1;
    }

    private static int findCycleLength(ListNode slow){
        ListNode current = slow;
        int cycleLength = 0;
        do{
            current = current.next;
            cycleLength++;
        }while(current != slow);

        return cycleLength;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + StartOfCycle.findCycleStart(head).data);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + StartOfCycle.findCycleStart(head).data);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + StartOfCycle.findCycleStart(head).data);
    }
}

