import java.util.Arrays;

public class DSA42 {

    // Check karo: kya 'minDist' distance rakh ke 'cows' gaaye baith sakti hain?
    private static boolean canPlace(int[] stalls, int cows, int minDist) {
        int count = 1;              // Pehli gaay pehle stall me
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            // Agar current stall aur last placed stall ka distance >= minDist hai
            if (stalls[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = stalls[i];
                if (count == cows) return true; // Saari gaayein baith gayi!
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int left  = 1;                              // Minimum possible distance
        int right = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlace(stalls, cows, mid)) {
                result = mid;       // Ye distance possible hai, aur bada try karo
                left = mid + 1;
            } else {
                right = mid - 1;   // Ye distance nahi chala, chota karo
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;

        System.out.println("Stalls: " + Arrays.toString(stalls));
        System.out.println("Cows:   " + cows);
        System.out.println("Max minimum distance: " + aggressiveCows(stalls, cows)); // 3
    }
}
