public class LinkedListFromScratch {
    Node head;
    
    public void add(int data) {
        // LL is empty
        if (this.head == null) {
            this.head = new Node(data);
        // LL is not empty
        } else {
            Node newNode = new Node(data);
            newNode.next = this.head;
            this.head = newNode;
        }
        
    }
    
    public static void main(String[] args) {
        LinkedListFromScratch myList = new LinkedListFromScratch();
        
        myList.add(10);
        myList.add(18);
        System.out.println(myList.head.data);
        System.out.println(myList.head.next.data);
    }
    
    
}

class Node {
    int data;
    Node next;
    
    Node (int data) {
        this.data = data;
    }
}