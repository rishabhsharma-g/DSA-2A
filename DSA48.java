import java.util.*;

public class DSA48 {

    // Kya saare courses complete ho sakte hain? (Cycle nahi honi chahiye)
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency list banao
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // pre[1] pehle karo, phir pre[0]
        }

        // 0 = unvisited, 1 = visiting (cycle check), 2 = done
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(graph, state, i)) return false;
        }

        return true;
    }

    private static boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        state[node] = 1; // Visiting shuru

        for (int neighbor : graph.get(node)) {
            if (state[neighbor] == 1) return true;  // Cycle mili!
            if (state[neighbor] == 0 && hasCycle(graph, state, neighbor)) return true;
        }

        state[node] = 2; // Done
        return false;
    }

    public static void main(String[] args) {
        // Case 1: 2 courses, [1,0] matlab course 1 ke liye pehle 0 karo → possible
        System.out.println("Case1 (no cycle): " + canFinish(2, new int[][]{{1, 0}}));        // true

        // Case 2: 2 courses, cycle hai 0→1→0 → impossible
        System.out.println("Case2 (cycle):    " + canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false

        // Case 3: 4 courses, koi cycle nahi
        System.out.println("Case3 (no cycle): " + canFinish(4, new int[][]{{1,0},{2,1},{3,2}})); // true
    }
}
