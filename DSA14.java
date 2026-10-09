public class DSA14 {
    
    public static String countAndSay(int n) {
        // Base case: n = 1 ke liye hamesha "1" hoga
        String result = "1";
        
        // Loop chalayenge 2 se lekar n tak, kyunki 1 ka answer toh pata hai
        for (int i = 2; i <= n; i++) {
            StringBuilder nextString = new StringBuilder(); // Nayi string banane ke liye
            
            int count = 1; // Padhne ki shuruaat (Ginti)
            
            // Pichli string (result) ke characters ko ek-ek karke padhenge
            for (int j = 1; j < result.length(); j++) {
                // Agar current character pichle character jaisa hi hai, toh ginti badhao
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } 
                // Agar character badal gaya, toh purane wale ki 'ginti' aur 'character' likh do
                else {
                    nextString.append(count).append(result.charAt(j - 1));
                    count = 1; // Naye character ke liye ginti wapas 1 kar do
                }
            }
            
            // Loop khatam hone ke baad sabse aakhiri character aur uski ginti bhi likh do
            nextString.append(count).append(result.charAt(result.length() - 1));
            
            // Ab agli baari ke liye 'result' ko update kar do
            result = nextString.toString();
        }
        
        return result;
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Count and Say for n = " + n + " is: " + countAndSay(n)); 
        // Output aayega: "1211"
        
        int n2 = 5;
        System.out.println("Count and Say for n = " + n2 + " is: " + countAndSay(n2)); 
        // Output aayega: "111221"
    }
}