import java.util.Arrays;

public class DSA7 {

    // Dutch National Flag Algorithm
    // 0 = Red, 1 = White, 2 = Blue
    public static void sortColors(int[] arr) {
        int low = 0;             // 0 yahan tak jayenge
        int mid = 0;             // current element
        int high = arr.length - 1; // 2 yahan se jayenge

        while (mid <= high) {
            if (arr[mid] == 0) {
                // 0 mila → aage bhejo
                int temp = arr[low]; arr[low] = arr[mid]; arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // 1 mila → sahi jagah hai, bas aage badho
                mid++;
            } else {
                // 2 mila → peeche bhejo
                int temp = arr[mid]; arr[mid] = arr[high]; arr[high] = temp;
                high--;
                // mid++ nahi karenge, peeche se aaya element check karna baaki hai
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};

        sortColors(arr);
        System.out.println(Arrays.toString(arr));
        // Output: [0, 0, 1, 1, 2, 2]
    }
}
