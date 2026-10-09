import java.util.ArrayList;

public class DSA33 {

    static int n;

    public static void findPaths(int[][] maze, int row, int col, boolean[][] visited, String path, ArrayList<String> result) {
        // Boundary ya wall ya already visited check
        if (row < 0 || col < 0 || row >= n || col >= n) return;
        if (maze[row][col] == 0 || visited[row][col]) return;

        // Destination pahunch gaye!
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        visited[row][col] = true; // Is cell par aa gaye

        // Charo directions me jao: Down, Left, Right, Up
        findPaths(maze, row + 1, col,     visited, path + "D", result);
        findPaths(maze, row,     col - 1, visited, path + "L", result);
        findPaths(maze, row,     col + 1, visited, path + "R", result);
        findPaths(maze, row - 1, col,     visited, path + "U", result);

        visited[row][col] = false; // Wapas aate waqt unmark karo (backtrack)
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };
        n = maze.length;

        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if (maze[0][0] == 1) {
            findPaths(maze, 0, 0, visited, "", result);
        }

        System.out.println("Paths: " + result);
        // Output: [DDRDRR, DRDDRR]
    }
}
