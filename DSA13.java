import java.util.Stack;

public class DSA13 {
    
    public static boolean isValid(String s) {
        // Ek khali dabba (Stack) banaya
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Step 1: Agar koi 'opening' bracket aaye, toh uska 'closing' judwa stack me daal do
            if (ch == '(') {
                stack.push(')');
            } 
            else if (ch == '{') {
                stack.push('}');
            } 
            else if (ch == '[') {
                stack.push(']');
            } 
            // Step 2: Agar closing bracket aaye, toh stack se aakhiri bracket nikal kar check karo
            else {
                // Agar stack khali hai (yani koi opening tha hi nahi) 
                // YA stack se nikla hua bracket match nahi hua
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false; // Toh string invalid hai
                }
            }
        }
        
        // Step 3: Pura check hone ke baad, agar stack khali hai toh Valid hai (true), warna Invalid (false)
        return stack.isEmpty();
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";
        
        System.out.println(s1 + " is valid? " + isValid(s1)); // Output: true
        System.out.println(s2 + " is valid? " + isValid(s2)); // Output: false
    }
}