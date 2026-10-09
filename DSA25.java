public class DSA25 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static void detectAndRemoveLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Step 1: Loop hai ya nahi — Floyd's Cycle Detection
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; // Loop mila!
        }

        // Agar loop nahi mila
        if (fast == null || fast.next == null) {
            System.out.println("Koi loop nahi hai.");
            return;
        }

        // Step 2: Loop ka start dhundho
        // slow ko head par wapas bhejo, fast wahi rahega jahan mile the
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Loop tod do — fast ab loop ke aakhiri node par hai
        fast.next = null;
        System.out.println("Loop detect aur remove ho gaya!");
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
        //                 ↑         |
        //                 └─────────┘  (5 ka next = 3, loop hai)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // Loop banaya (5 -> 3)

        detectAndRemoveLoop(head);

        System.out.print("List after loop remove: ");
        printList(head);
        // Output: 1 -> 2 -> 3 -> 4 -> 5
    }
}
