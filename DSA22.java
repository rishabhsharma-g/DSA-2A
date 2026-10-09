public class DSA22 {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Slow-Fast pointer se list ka middle dhundho
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow ab middle par hai

        // Step 2: Middle se aage wali list ko reverse karo
        Node secondHalf = reverse(slow);

        // Step 3: Pehli half aur reversed second half compare karo
        Node left = head, right = secondHalf;
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // List reverse karne ka helper
    private static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // List 1: 1 -> 2 -> 3 -> 2 -> 1  (Palindrome)
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);

        // List 2: 1 -> 2 -> 3  (Palindrome nahi)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.println("List1 Palindrome hai? " + isPalindrome(head1)); // true
        System.out.println("List2 Palindrome hai? " + isPalindrome(head2)); // false
    }
}
