import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class DS {
    public static void main(String[] args) {
        
        // 1) List INTERFACE
        // ARRAYLIST
        List<Integer> arraylist = new ArrayList<>();
        arraylist.add(1);
        arraylist.add(2);
        arraylist.add(3);
        arraylist.add(4);
        arraylist.add(5);
        arraylist.add(6);
        // System.out.println(arraylist.get(2));
        // System.out.println(arraylist.remove(3));
        // System.out.println(arraylist.size());
        // System.out.println(arraylist);

        // LINKEDLIST
        LinkedList<Integer> linkedlist = new LinkedList<>();
        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);
        // System.out.println(linkedlist.remove()); // remove first
        // System.out.println(linkedlist.peek());
        // System.out.println(linkedlist);

        // STACK
        Stack<Integer> stack =  new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6); // add first
        // System.out.println(stack.pop()); // remove first
        // System.out.println(stack.peek()); // get first
        // System.out.println(stack);
        

        // VECTOR

        // 2) Queue INTERFACE

        // ArrayDeque and LinkedList both inpliments Deque Interface
        // ARRAYDEQUE
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        // Deque as queue [FIFO] { offer, poll, peek }
        deque.offer(1); // add last
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.poll()); // remove first
        System.out.println(deque.peek()); // get first

        // Deque as Stack [LIFO] { push, pop, peek }
        deque.push(4); // add first
        deque.push(5);
        deque.push(6);
        System.out.println(deque);
        System.out.println(deque.pop()); // remove first
        System.out.println(deque.peek()); // get first

        // PRIORITY QUEUE
        PriorityQueue<Integer> priorityqueue = new PriorityQueue<>();

        // 2) Map INTERFACE
        // HASHMAP
        HashMap<Integer, String> map = new HashMap<>();

        // ENUM MAP
        // LINKED HASH MAP
        // TREE MAP
        // WEAK HASH MAP

        // 2) Set INTERFACE
        // HASHSET
        HashSet<Integer> set = new HashSet<>();

        // ENUM SET
        // LINKED HASH SET
        // TREE SET

    }
}
