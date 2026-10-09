public class DSA20 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) { sum += l1.data; l1 = l1.next; }
            if (l2 != null) { sum += l2.data; l2 = l2.next; }

            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        System.out.print("Result: ");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // Number 1: 342  →  List: 2 -> 4 -> 3
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Number 2: 465  →  List: 5 -> 6 -> 4
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        // 342 + 465 = 807  →  Output: 7 -> 0 -> 8
        Node result = addTwoNumbers(l1, l2);
        printList(result);
    }
}
