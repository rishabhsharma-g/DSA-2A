public class DSA19 {
    
    // Linked List ka Node structure
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getIntersectionNode(Node headA, Node headB) {
        // Agar koi bhi list khali hai, toh intersection ho hi nahi sakta
        if (headA == null || headB == null) return null;
        
        Node ptr1 = headA;
        Node ptr2 = headB;
        
        // Jab tak dono pointers ek hi jagah (Node) par na mil jayein
        while (ptr1 != ptr2) {
            // Agar ptr1 apni list ke end (null) par pahunch gaya, toh usko dusri list (headB) par bhej do
            // Warna ek kadam aage badhao
            ptr1 = (ptr1 == null) ? headB : ptr1.next;
            
            // Agar ptr2 apni list ke end (null) par pahunch gaya, toh usko pehli list (headA) par bhej do
            // Warna ek kadam aage badhao
            ptr2 = (ptr2 == null) ? headA : ptr2.next;
        }
        
        // Jab loop tootega, tab ya toh dono Intersection Node par honge, ya dono null par honge
        return ptr1; 
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        // List A banate hain: 4 -> 1 \
        //                             8 -> 4 -> 5
        // List B banate hain: 5 -> 6 /
        
        // Common part banate hain
        Node common = new Node(8);
        common.next = new Node(4);
        common.next.next = new Node(5);
        
        // List A
        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = common; // Intersection point (8)
        
        // List B
        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = common; // Intersection point (8)
        
        Node intersection = getIntersectionNode(headA, headB);
        
        if (intersection != null) {
            System.out.println("Intersection Point is: " + intersection.data); 
            // Output aayega: Intersection Point is: 8
        } else {
            System.out.println("No Intersection Point found.");
        }
    }
}