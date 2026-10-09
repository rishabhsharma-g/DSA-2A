import java.util.ArrayList;
import java.util.List;

public class DSA34 {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Board ko '.' se bharo
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        solve(board, 0, n, result);
        return result;
    }

    private static void solve(char[][] board, int row, int n, List<List<String>> result) {
        // Saari rows me queen rakh di — solution mila!
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            result.add(solution);
            return;
        }

        // Is row me har column try karo
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';          // Queen rakho
                solve(board, row + 1, n, result); // Agli row me jao
                board[row][col] = '.';           // Backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Upar same column check
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // Upper-left diagonal check
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // Upper-right diagonal check
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);

        System.out.println("N = " + n + ", Total Solutions: " + result.size());
        for (List<String> solution : result) {
            for (String row : solution) System.out.println(row);
            System.out.println();
        }
    }
}
