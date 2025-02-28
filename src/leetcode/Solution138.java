package leetcode;
import leetcode.helper.Node;

class Solution138 {

    public static void main(String[] args) {
        var head = new Node(7);
        head.setNext(new Node(13));
        head.getNext().setRandom(head);
        head.getNext().setNext(new Node(11));
        head.getNext().getNext().setNext(new Node(10));
        head.getNext().getNext().getNext().setNext(new Node(1));

        head.getNext().getNext().setRandom(head.getNext().getNext().getNext().getNext());
        head.getNext().getNext().getNext().setRandom(head.getNext().getNext());
        head.getNext().getNext().getNext().getNext().setRandom(head);

        System.out.println("Original List:");
        printList(head);

        Node copiedList = copyRandomList(head);

        System.out.println("Copied List:");
        printList(copiedList);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.getVal());
            copy.setNext(current.getNext());
            current.setNext(copy);
            current = copy.getNext();
        }

        current = head;
        while (current != null) {
            if (current.getRandom() != null) {
                current.getNext().setRandom(current.getRandom().getNext());
            }
            current = current.getNext().getNext();
        }

        Node dummyHead = new Node(0);
        Node copyCurrent = dummyHead;
        current = head;

        while (current != null) {
            copyCurrent.setNext(current.getNext());
            copyCurrent = copyCurrent.getNext();
            current.setNext(current.getNext().getNext());
            current = current.getNext();
        }

        return dummyHead.getNext();
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("(" + current.getVal() + ", " +
                    (current.getRandom() != null ? current.getRandom().getVal() : "null") + ") -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
