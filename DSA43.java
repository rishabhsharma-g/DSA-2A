import java.util.Arrays;

public class DSA43 {

    // Check karo: kya 'students' students me books baant sakte hain jab max pages = limit ho?
    private static boolean canAllocate(int[] books, int students, int limit) {
        int studentCount = 1;
        int pagesSum = 0;

        for (int pages : books) {
            // Agar ek book hi limit se badi hai, possible nahi
            if (pages > limit) return false;

            if (pagesSum + pages > limit) {
                // Naye student ko do
                studentCount++;
                pagesSum = pages;
                if (studentCount > students) return false;
            } else {
                pagesSum += pages;
            }
        }
        return true;
    }

    public static int bookAllocation(int[] books, int students) {
        // Agar students books se zyada hain
        if (students > books.length) return -1;

        int left  = Arrays.stream(books).max().getAsInt(); // Kam se kam itna toh hoga
        int right = Arrays.stream(books).sum();            // Zyada se zyada itna hoga
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canAllocate(books, students, mid)) {
                result = mid;       // Ye possible hai, aur chota try karo
                right = mid - 1;
            } else {
                left = mid + 1;    // Ye nahi chala, bada karo
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;

        System.out.println("Books:    " + Arrays.toString(books));
        System.out.println("Students: " + students);
        System.out.println("Min of max pages: " + bookAllocation(books, students)); // 113
    }
}
