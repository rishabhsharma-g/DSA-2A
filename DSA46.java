import java.util.*;

public class DSA46 {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    public static void verticalOrder(Node root) {
        if (root == null) return;

        // Map: column → us column ke saare nodes
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // Queue me node aur uska column store karenge
        Queue<int[]> queue = new LinkedList<>(); // [node ka data, column]
        Map<Node, Integer> colMap = new HashMap<>();

        colMap.put(root, 0);
        queue.offer(new int[]{0}); // sirf column track karne ke liye
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll();
            int col   = colMap.get(curr);

            map.computeIfAbsent(col, k -> new ArrayList<>()).add(curr.data);

            if (curr.left != null) {
                colMap.put(curr.left, col - 1);
                nodeQueue.offer(curr.left);
            }
            if (curr.right != null) {
                colMap.put(curr.right, col + 1);
                nodeQueue.offer(curr.right);
            }
        }

        System.out.println("Vertical Order Traversal:");
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println("Col " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7
        Node root = new Node(1);
        root.left  = new Node(2);
        root.right = new Node(3);
        root.left.left   = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        root.right.right = new Node(7);

        verticalOrder(root);
        // Col -2: [4]
        // Col -1: [2]
        // Col  0: [1, 5, 6]
        // Col  1: [3]
        // Col  2: [7]
    }
}
