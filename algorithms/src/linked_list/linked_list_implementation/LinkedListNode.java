public class LinkedListNode {
    
    int key;
    int data;
    LinkedListNode next;
    LinkedListNode arbitraryPointer;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int key, int data){
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int data, LinkedListNode next){
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitraryPointer){
        this.data = data;
        this.next = next;
        this.arbitraryPointer = arbitraryPointer;
    }

}
