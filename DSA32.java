import java.util.HashMap;
import java.util.LinkedList;

public class DSA32 {

    static class LRUCache {
        int capacity;
        HashMap<Integer, Integer> map;   // key → value
        LinkedList<Integer> deque;       // Most recent = front, Least recent = back

        LRUCache(int capacity) {
            this.capacity = capacity;
            map   = new HashMap<>();
            deque = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;

            // Use hua toh sabse aage le aao (most recently used)
            deque.remove((Integer) key);
            deque.addFirst(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // Pehle se hai — update karo aur aage le aao
                deque.remove((Integer) key);
            } else if (map.size() == capacity) {
                // Cache full — sabse purana (last) hatao
                int lru = deque.removeLast();
                map.remove(lru);
            }

            deque.addFirst(key);
            map.put(key, value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        System.out.println("Get 1: " + cache.get(1)); // 10  (1 ab most recent)
        cache.put(4, 40);                              // 2 remove hoga (least recent)

        System.out.println("Get 2: " + cache.get(2)); // -1  (2 remove ho gaya)
        System.out.println("Get 3: " + cache.get(3)); // 30
        System.out.println("Get 4: " + cache.get(4)); // 40
    }
}
