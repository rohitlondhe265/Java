package LinkedLists;

public class CLL {
    private Node head;
    private Node tail;
    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = tail = node;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
    }
    public void delete(int val) {
        Node node = head;
        if(node == null) {
            return;
        }
        if(node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node n = node.next;
            if(n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }
    public void display() {
        Node node = head;
        if(head != null) {
            do {
                System.out.print(node.val + " -> ");
                node = node.next;
            } while (node != head);
        }
    }
    private class Node {
        private int val;
        private Node next;
       public Node(int value) {
         this.val = value;
        }
       public Node(int value, Node next) {
         this.next = next;
         this.val = value;
        }
     }
}
