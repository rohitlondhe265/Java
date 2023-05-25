package LinkedLists.questions;

import LinkedLists.LL;
import LinkedLists.LL.Node;

public class Easy {

    // 1). insert in linked list using recursion
    // public Node insertRec(int val, int index, Node node) {
    //     if (index == 0) {
    //         Node temp = new Node(val, node);
    //         return temp;
    //     }
    //     node.next = insertRec(val, index - 1, node.next);
    //     return node;
    // }

    // 2). remove duplicates from a sorted list
    public Node deleteDupli(Node node) {
        if (node == null) {
            return node;
        }
        Node head = node;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    // 3). merge two sorted lists
    public LL mergeSort(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;
        LL ans = new LL();
        while(f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }
        while(f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }
        while(s != null) {
            ans.insertLast(s.val);
            s = s.next;
        }
        return ans;
    }
    // 4). Linked list cycle detection
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    // 5). 

}
