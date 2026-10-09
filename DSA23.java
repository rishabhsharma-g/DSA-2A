public class DSA23 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        // Dummy node taaki head delete karna bhi asaan ho
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy, slow = dummy;

        // Step 1: Fast pointer ko n+1 steps aage bhejo
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: Dono pointers saath chalao jab tak fast end par na pahunche
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: slow ab us node ke pehle wale par hai — delete karo
        slow.next = slow.next.next;

        return dummy.next;
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
        // List: 1 -> 2 -> 3 -> 4 -> 5,  n = 2
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Before: ");
        printList(head);

        head = removeNthFromEnd(head, 2);

        System.out.print("After:  ");
        printList(head);
        // Output: 1 -> 2 -> 3 -> 5  (4 delete hua)
    }
}
