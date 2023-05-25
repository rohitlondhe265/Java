package LinkedLists;

public class DLL {
    Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    public void insertLast(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            return;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }
    public void insertAfter(int after, int val) {
        Node p = find(after);
        if(p == null) {
            System.out.println("node doesn't exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        if(node.next != null) {
            node.next.prev = node;
        }
    }
    public Node find(int val) {
        Node temp = head;
        while(temp != null) {
            if(temp.val == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }
    public void displayRev() {
        Node temp = head;
        Node last = null;
        while(temp != null) {
            last = temp;
            temp = temp.next;
        }
        while(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("Start");
    }

    private class Node {
        int val;
        Node next;
        Node prev;
       public Node(int val) {
            this.val = val;
        }
       public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
