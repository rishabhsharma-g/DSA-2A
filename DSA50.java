import java.util.*;

public class DSA50 {

    // beginWord se endWord tak pahunchne ke liye minimum steps
    public static int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0; // endWord list me nahi hai

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Har character ko A-Z se badal ke dekho
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        chars[j] = c;
                        String newWord = new String(chars);

                        if (newWord.equals(endWord)) return steps + 1; // Mil gaya!

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Dobara visit na ho
                        }
                    }

                    chars[j] = original; // Wapas original character
                }
            }

            steps++;
        }

        return 0; // Nahi pahuncha
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        String begin = "hit";
        String end   = "cog";

        System.out.println("Begin: " + begin + ", End: " + end);
        System.out.println("Word List: " + wordList);
        System.out.println("Min Steps: " + wordLadder(begin, end, wordList));
        // hit → hot → dot → dog → cog = 5 steps
    }
}
