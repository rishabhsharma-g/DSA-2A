import java.util.Arrays;

public class DSA39 {

    // Pehli baar kahan aaya
    private static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // Mil gaya, par aur left me dhundho
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Aakhiri baar kahan aaya
    private static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;       // Mil gaya, par aur right me dhundho
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 6, 6, 8, 10};
        int target = 6;

        System.out.println("Array:  " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("First Occurrence: index " + firstOccurrence(arr, target)); // 2
        System.out.println("Last  Occurrence: index " + lastOccurrence(arr, target));  // 4
    }
}
