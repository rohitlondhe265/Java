public class customStack {
    // implimenting stack using the linked list
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }
     class Stack{
        public Node head;
        public boolean isEmpty(){
            return head == null;
        }
        public void push(int n){
            Node newNode = new Node(n);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        while(s.isEmpty()){

        }
    }
}
