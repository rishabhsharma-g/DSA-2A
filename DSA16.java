public class DSA16 {
    
    // d = 256 kyunki ASCII mein 256 characters hote hain
    public final static int d = 256; 
    
    public static void search(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        
        // Agar pattern text se bada hai, toh mil hi nahi sakta
        if (m > n) return; 

        int pHash = 0; // Pattern ka hash value
        int tHash = 0; // Text ki current window ka hash value
        int q = 101;   // Ek Prime number (taaki calculation itni badi na ho jaye ki memory me na aaye)
        int h = 1;

        // Step 1: 'h' ki value nikalna (jo sabse aage wale character ko hatane me kaam aayegi)
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Step 2: Pattern ka aur Text ki pehli window ka Hash calculate karna
        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }

        // Step 3: Text ke upar window slide karna
        for (int i = 0; i <= n - m; i++) {
            
            // Agar dono ke Hash match ho gaye!
            if (pHash == tHash) {
                // Toh check karo ki kya sach mein spelling bhi same hai? (Kyunki kabhi-kabhi alag words ka hash same aa sakta hai)
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break; // Spelling match nahi hui
                    }
                }
                // Agar poori spelling match ho gayi
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Agli window ka naya Hash calculate karo (Rolling Hash)
            if (i < n - m) {
                // Purane wale character ko hatao, aur naye wale ko jodo
                tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // Agar hash negative me chala jaye, toh usko positive banao
                if (tHash < 0) {
                    tHash = (tHash + q);
                }
            }
        }
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Results: ");
        search(pattern, text); 
        // Output aayega: 
        // Pattern found at index 0
        // Pattern found at index 10
    }
}