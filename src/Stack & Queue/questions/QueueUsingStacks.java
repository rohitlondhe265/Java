import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    // Remove Efficient Code
    public void push(int val) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        second.push(val);
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }
    public int pop() {
        return first.pop();
    }
    public int peek() {
        return first.peek();
    }

    // // Insert Efficient Code
    // public void push(int val) {
    //     first.push(val);
    // }
    // public int pop() {
    //     while (!first.isEmpty()) {
    //         second.push(first.pop());
    //     }
    //     int removed = second.pop();
    //     while (!second.isEmpty()) {
    //         first.push(second.pop());
    //     }
    //     return removed;
    // }
    // public int peek() {
    //     while (!first.isEmpty()) {
    //         second.push(first.pop());
    //     }
    //     int peeked = second.peek();
    //     while(!second.isEmpty()) {
    //         first.push(second.pop());
    //     }
    //     return peeked;
    // }
    public boolean isEmpty() {
        return first.isEmpty();
    }
}
