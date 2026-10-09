public class DSA17 {
    
    // KMP Search function
    public static void KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        
        // LPS array banayenge jo pattern ke size ka hoga
        int[] lps = new int[m];
        
        // Step 1: LPS array ko calculate karo (Helper function call)
        computeLPSArray(pat, m, lps);
        
        int i = 0; // Text ka pointer
        int j = 0; // Pattern ka pointer
        
        // Step 2: Text par loop chalao
        while (i < n) {
            // Agar character match ho jaye, toh dono pointers aage badhao
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            
            // Agar poora pattern match ho gaya (j badhte-badhte m ke barabar ho gaya)
            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                // Agla pattern dhoondhne ke liye j ko thoda peeche karo (LPS ki madad se)
                j = lps[j - 1];
            } 
            
            // Agar mismatch ho jaye (characters barabar na ho)
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    // Agar j zero nahi hai, toh zero par mat jao! LPS array se pucho kahan jana hai
                    j = lps[j - 1];
                } else {
                    // Agar j pehle se hi zero par hai, toh majbooran text (i) ko aage badhana padega
                    i++;
                }
            }
        }
    }
    
    // LPS (Longest Prefix Suffix) Array banane ka function
    private static void computeLPSArray(String pat, int m, int[] lps) {
        int len = 0; // Pichle sabse lambe prefix-suffix ki lambai
        int i = 1;
        lps[0] = 0; // Pehle character ka LPS hamesha 0 hota hai
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Trick: len ko peeche khiskao
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        
        System.out.println("Text: " + txt);
        System.out.println("Pattern: " + pat);
        System.out.println("Results:");
        KMPSearch(pat, txt);
        // Output aayega: Pattern found at index 10
    }
}