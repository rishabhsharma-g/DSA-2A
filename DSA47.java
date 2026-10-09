import java.util.*;

public class DSA47 {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    public static List<List<Integer>> zigzagTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Pehla level left se right

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                // Direction ke hisaab se add karo
                if (leftToRight) {
                    level.addLast(curr.data);  // Normal order
                } else {
                    level.addFirst(curr.data); // Ulta order
                }

                if (curr.left  != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // Har level pe direction badlo
        }

        return result;
    }

    public static void main(String[] args) {
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        Node root = new Node(3);
        root.left  = new Node(9);
        root.right = new Node(20);
        root.right.left  = new Node(15);
        root.right.right = new Node(7);

        List<List<Integer>> result = zigzagTraversal(root);

        System.out.println("Zigzag Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
        // [3]
        // [20, 9]
        // [15, 7]
    }
}
