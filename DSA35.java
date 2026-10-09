import java.util.ArrayList;
import java.util.List;

public class DSA35 {

    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    private static void generate(int n, int open, int close, String current, List<String> result) {
        // Jab string poori ban jaye
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Opening bracket tab daalo jab open < n
        if (open < n)
            generate(n, open + 1, close, current + "(", result);

        // Closing bracket tab daalo jab close < open
        if (close < open)
            generate(n, open, close + 1, current + ")", result);
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParentheses(n);

        System.out.println("n = " + n + ", Total: " + result.size());
        for (String s : result) System.out.println(s);
        // Output: ((())), (()()), (())(), ()(()), ()()()
    }
}
