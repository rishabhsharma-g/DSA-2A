public class DSA31 {

    static class CircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            arr   = new int[capacity];
            front = 0;
            rear  = -1;
            size  = 0;
        }

        // Queue me daalo
        public boolean enqueue(int val) {
            if (isFull()) {
                System.out.println("Queue Full! " + val + " add nahi hua.");
                return false;
            }
            rear = (rear + 1) % capacity; // Circular wrap-around
            arr[rear] = val;
            size++;
            return true;
        }

        // Queue se nikalo
        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue Khali hai!");
                return -1;
            }
            int val = arr[front];
            front = (front + 1) % capacity; // Circular wrap-around
            size--;
            return val;
        }

        public int peek()     { return isEmpty() ? -1 : arr[front]; }
        public boolean isFull()  { return size == capacity; }
        public boolean isEmpty() { return size == 0; }
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(4);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50); // Full hogi

        System.out.println("Front: "   + cq.peek());          // 10
        System.out.println("Dequeue: " + cq.dequeue());       // 10
        System.out.println("Dequeue: " + cq.dequeue());       // 20
        cq.enqueue(50); // Ab space hai
        System.out.println("Front now: " + cq.peek());        // 30
    }
}
