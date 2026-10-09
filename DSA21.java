public class DSA21 {

    // Node structure
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node rotateRight(Node head, int k) {
        // Agar list khali hai ya sirf 1 node hai, kuch karne ki zarurat nahi
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: List ki length nikalo aur tail (aakhiri node) dhundho
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: k ko length se mod karo (agar k = length ho toh kuch nahi badlega)
        k = k % length;
        if (k == 0) return head;

        // Step 3: Naya tail dhundho — (length - k - 1) steps aage jaao
        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 4: Naya head set karo
        Node newHead = newTail.next;

        // Step 5: Connections tod aur jod do
        newTail.next = null;   // Naya tail yahan khatam hoga
        tail.next = head;      // Purana tail, purane head se jud jayega (circle tod ke)

        return newHead;
    }

    // List print karne ka helper
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

        System.out.print("Before Rotate: ");
        printList(head);

        head = rotateRight(head, 2);

        System.out.print("After Rotate:  ");
        printList(head);
        // Output: 4 -> 5 -> 1 -> 2 -> 3
    }
}
