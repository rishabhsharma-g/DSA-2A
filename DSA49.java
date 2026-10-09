import java.util.*;

public class DSA49 {

    // Bipartite = graph ko 2 colors me rang sako jahan koi 2 adjacent nodes same color na ho
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = red, -1 = blue
        Arrays.fill(color, 0);

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !bfsCheck(graph, color, i)) return false;
        }

        return true;
    }

    private static boolean bfsCheck(int[][] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // Pehle node ko red color do

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    // Uncolored hai → opposite color do
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // Same color → Bipartite nahi hai!
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Bipartite graph: 0-1-2-3 (square)
        int[][] graph1 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        // Non-bipartite graph: triangle (odd cycle)
        int[][] graph2 = {{1, 2}, {0, 2}, {0, 1}};

        System.out.println("Graph1 (square) bipartite?   " + isBipartite(graph1)); // true
        System.out.println("Graph2 (triangle) bipartite? " + isBipartite(graph2)); // false
    }
}
