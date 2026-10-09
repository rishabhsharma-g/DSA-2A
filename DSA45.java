public class DSA45 {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Height return karta hai, agar unbalanced ho toh -1 return karta hai
    private static int checkHeight(Node node) {
        if (node == null) return 0;

        int left  = checkHeight(node.left);
        if (left == -1) return -1;  // Left subtree unbalanced hai

        int right = checkHeight(node.right);
        if (right == -1) return -1; // Right subtree unbalanced hai

        // Agar dono ka difference 1 se zyada hai → unbalanced
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1; // Height return karo
    }

    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        //    Balanced Tree        Unbalanced Tree
        //        1                     1
        //       / \                   /
        //      2   3                 2
        //     / \                   /
        //    4   5                 3

        Node balanced = new Node(1);
        balanced.left  = new Node(2);
        balanced.right = new Node(3);
        balanced.left.left  = new Node(4);
        balanced.left.right = new Node(5);

        Node unbalanced = new Node(1);
        unbalanced.left = new Node(2);
        unbalanced.left.left = new Node(3);

        System.out.println("Tree1 balanced? " + isBalanced(balanced));   // true
        System.out.println("Tree2 balanced? " + isBalanced(unbalanced)); // false
    }
}
