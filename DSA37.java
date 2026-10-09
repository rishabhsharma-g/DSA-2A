public class DSA37 {

    public static boolean hasSubsetSum(int[] arr, int target) {
        return solve(arr, target, 0);
    }

    private static boolean solve(int[] arr, int remaining, int index) {
        // Target mil gaya!
        if (remaining == 0) return true;

        // Array khatam ya sum negative ho gaya
        if (index == arr.length || remaining < 0) return false;

        // 2 choices: current element lo YA mat lo
        return solve(arr, remaining - arr[index], index + 1) || // Lo
               solve(arr, remaining,               index + 1);  // Mat lo
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};

        System.out.println("Array: {3, 34, 4, 12, 5, 2}");
        System.out.println("Sum 9  possible? " + hasSubsetSum(arr, 9));  // true  (4+5)
        System.out.println("Sum 30 possible? " + hasSubsetSum(arr, 30)); // false
    }
}
