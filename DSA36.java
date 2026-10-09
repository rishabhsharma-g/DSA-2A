public class DSA36 {

    public static boolean wordSearch(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        // Har cell se word dhundhna shuru karo
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (dfs(board, word, i, j, 0)) return true;

        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Poora word mil gaya!
        if (index == word.length()) return true;

        // Boundary ya wrong character check
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if (board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#'; // Visited mark karo

        // Charo directions me dhundho
        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        board[row][col] = temp; // Backtrack — wapas original character
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        System.out.println("Word 'ABCCED' found? " + wordSearch(board, "ABCCED")); // true
        System.out.println("Word 'SEE' found?    " + wordSearch(board, "SEE"));    // true
        System.out.println("Word 'ABCB' found?   " + wordSearch(board, "ABCB"));   // false
    }
}
