public class DSA24 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) return head;

        Node odd = head;          // Odd nodes ki list (1st, 3rd, 5th...)
        Node even = head.next;    // Even nodes ki list (2nd, 4th, 6th...)
        Node evenHead = even;     // Even list ka start yaad rakhna hai

        while (even != null && even.next != null) {
            odd.next = even.next;   // Odd ka next → agle odd par
            odd = odd.next;

            even.next = odd.next;   // Even ka next → agle even par
            even = even.next;
        }

        // Odd list ke end mein even list jod do
        odd.next = evenHead;

        return head;
    }

    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // List: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Before: ");
        printList(head);

        head = oddEvenList(head);

        System.out.print("After:  ");
        printList(head);
        // Output: 1 -> 3 -> 5 -> 2 -> 4
    }
}
