public class DSA44 {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    public static Node lca(Node root, int p, int q) {
        if (root == null) return null;

        // Agar root khud p ya q hai, toh root hi LCA hai
        if (root.data == p || root.data == q) return root;

        // Left aur right dono me dhundho
        Node left  = lca(root.left,  p, q);
        Node right = lca(root.right, p, q);

        // Agar dono sides se kuch mila → root hi LCA hai
        if (left != null && right != null) return root;

        // Jis side se mila, wahi return karo
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        //        3
        //       / \
        //      5   1
        //     / \ / \
        //    6  2 0  8
        Node root    = new Node(3);
        root.left    = new Node(5);
        root.right   = new Node(1);
        root.left.left  = new Node(6);
        root.left.right = new Node(2);
        root.right.left  = new Node(0);
        root.right.right = new Node(8);

        System.out.println("LCA(6, 2): " + lca(root, 6, 2).data); // 5
        System.out.println("LCA(5, 1): " + lca(root, 5, 1).data); // 3
        System.out.println("LCA(6, 8): " + lca(root, 6, 8).data); // 3
    }
}
