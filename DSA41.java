public class DSA41 {

    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Agar mid ka next bada hai, peak right me hoga
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Warna peak left me hai (ya mid khud peak hai)
                right = mid;
            }
        }

        return left; // left == right == peak index
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 20, 4, 1, 0};
        int[] arr2 = {1, 2, 3, 4, 5};

        int idx1 = findPeak(arr1);
        int idx2 = findPeak(arr2);

        System.out.println("Array1: [1, 3, 20, 4, 1, 0]");
        System.out.println("Peak index: " + idx1 + ", value: " + arr1[idx1]); // index 2, value 20

        System.out.println("Array2: [1, 2, 3, 4, 5]");
        System.out.println("Peak index: " + idx2 + ", value: " + arr2[idx2]); // index 4, value 5
    }
}
