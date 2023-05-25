package LinkedLists;

public class LL {
    public Node head;
    public Node tail;
    public int size;
    public LL(){
        this.size = 0;
    }
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;
        }
        size++;
    }
    public void insertLast(int value) {
        if(tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insert(int value, int index) {
        if(index == 0) {
            insertFirst(value);
            return;
        }
        if(index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

        // 1). insert in linked list using recursion
        public void insertRec(int val, int index) {
            head = insertRec(val, index, head);
        }
        private Node insertRec(int val, int index, Node node) {
            if(index == 0) {
                Node temp = new Node(val, node);
                return temp;
            }
            node.next = insertRec(val, index-1, node.next);
            return node;
        }

    public int deleteFirst() {
        int val = head.val;
        if(head == null) {
            tail = null;
            return -1;
        }
        head = head.next;
        return val;
    }
    public int deleteLast() {
        if(size <= 1) {
            deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public int delete(int index) {
        if(index == 0) {
            return deleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }
        Node pre = get(index - 1);
        int val = pre.next.val;
        pre.next = pre.next.next;
        return val;
    }
    public Node find(int value) {
        Node node = head;
        while(node != null) {
            if(node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next) {
            this.next = next;
            this.val = value;
        }

    }
}
