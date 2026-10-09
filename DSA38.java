import java.util.ArrayList;
import java.util.List;

public class DSA38 {

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        generate(arr, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generate(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        // Har step par current subset result me daalo
        result.add(new ArrayList<>(current));

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);              // Element lo
            generate(arr, i + 1, current, result); // Aage jao
            current.remove(current.size() - 1);    // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<List<Integer>> result = subsets(arr);

        System.out.println("Array: {1, 2, 3}");
        System.out.println("Total Subsets: " + result.size()); // 8 (2^3)
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
        // [], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]
    }
}
