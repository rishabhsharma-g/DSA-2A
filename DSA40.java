public class DSA40 {

    public static int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;

            // Left half sorted hai?
            if (arr[left] <= arr[mid]) {
                // Target left half me hai?
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half sorted hai
                // Target right half me hai?
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Nahi mila
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Array: [4, 5, 6, 7, 0, 1, 2]");
        System.out.println("Search 0: index " + search(arr, 0)); // 4
        System.out.println("Search 6: index " + search(arr, 6)); // 2
        System.out.println("Search 3: index " + search(arr, 3)); // -1
    }
}
