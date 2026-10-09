/*
Question 12: Longest Repeating Character Replacement

Given a string s and integer k,
you can replace at most k characters.

Find length of longest substring containing same character.

Example:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: "AABA"
*/

public class DSA15
 {

    public static int characterReplacement(String s, int k) {
        // Lowercase aur uppercase dono handle karne ke liye
        s = s.toUpperCase();
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("AABABBA", 1));

    }
}

