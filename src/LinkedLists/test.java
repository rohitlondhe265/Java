package LinkedLists;

public class test {
    public static void main(String[] args) {
        LL list = new LL();
        // DLL list = new DLL();
        // CLL list = new CLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(99);
        // list.insertAfter(2, 65);
        // list.insert(55, 3);
        // list.deleteFirst();
        // System.out.println(list.deleteLast());
        // System.out.println(list.delete(2));
        // list.insert(3);
        // list.insert(2);
        // list.insert(1);
        // list.delete(2);
        list.display();
        list.insertRec(55, 2);
        list.display();
        // list.displayRev();
    }
}
