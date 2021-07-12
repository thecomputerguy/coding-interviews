import java.util.List;
import java.util.Random;

public class LinkedList {

    public static LinkedListNode insertAtHead(LinkedListNode head, int data){
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = head;
        return newNode;
    }

    public static LinkedListNode insertAtTail(LinkedListNode head, int data){
        LinkedListNode newNode = new LinkedListNode(data);
        if(head == null){
            return newNode;
        }
        LinkedListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static LinkedListNode createLinkedList(List<Integer> elements){
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for (Integer element : elements) {
            LinkedListNode newNode = new LinkedListNode(element);
            if(head == null){
                head = newNode;
            }else{
                tail.next = newNode;
            }

            tail = newNode;
        }

        return head;
    }

    public static LinkedListNode createLinkedList(int[] elements){
        LinkedListNode head = null;
        LinkedListNode tail = null;
        for (Integer element : elements){
            LinkedListNode newNode = new LinkedListNode(element);
            if(head == null){
                head = newNode;
            }else{
                tail.next = newNode;
            }
            tail = newNode;
        }

        return head;
    }

    public static LinkedListNode createRandomList(int length){
        LinkedListNode head = null;
        Random generator = new Random();
        for (int i = 0; i < length; i++) {
            head = insertAtHead(head, generator.nextInt());
        }

        return head;
    }

    public static void display(LinkedListNode head){
        LinkedListNode current = head;
        while (current != null) {
            System.out.printf("%d", current.data);
            current = current.next;
            if(current != null){
                System.out.printf(", ");
            }
        }
        System.out.println();
    }
}

class Pair<X, Y>{
    public X first;
    public Y second;

    public Pair(X x, Y y) {
        this.first = x;
        this.second = y;
    }
}