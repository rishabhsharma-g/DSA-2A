public class DSA18 {
    
    public static String minWindow(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();

        // Agar original string choti hai pattern se, toh answer mil hi nahi sakta
        if (len1 < len2) {
            return "";
        }

        int[] hashPat = new int[256]; // Pattern ke characters ginne ke liye
        int[] hashStr = new int[256]; // Humari current window ke characters ginne ke liye

        // Step 1: Pattern mein kaunsa character kitni baar hai, uski ginti save kar lo
        for (int i = 0; i < len2; i++) {
            hashPat[pat.charAt(i)]++;
        }

        int start = 0, startIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0; // Ye batayega ki humne kitne 'kaam ke' characters dhoondh liye hain

        // Step 2: String mein right side (j pointer) se aage badhna shuru karo
        for (int j = 0; j < len1; j++) {
            char currentChar = str.charAt(j);
            
            // Naye character ko window (hashStr) mein add karo
            hashStr[currentChar]++;

            // Agar ye character pattern me hai, aur hume iski zarurat thi, toh count badhao
            if (hashPat[currentChar] != 0 && hashStr[currentChar] <= hashPat[currentChar]) {
                count++;
            }

            // Step 3: Agar hume saare characters mil gaye (count == len2), toh window shrink karna shuru karo
            if (count == len2) {
                
                // Left se 'kachra' hatao: 
                // Ya toh wo character pattern me hai hi nahi (hashPat == 0)
                // Ya fir humari window me wo zarurat se zyada baar aa gaya hai (hashStr > hashPat)
                while (hashStr[str.charAt(start)] > hashPat[str.charAt(start)] 
                        || hashPat[str.charAt(start)] == 0) {
                    
                    if (hashStr[str.charAt(start)] > hashPat[str.charAt(start)]) {
                        hashStr[str.charAt(start)]--; // Ginti kam karo
                    }
                    start++; // Window ko left se chota karo
                }

                // Window shrink karne ke baad, iski lambai check karo
                int windowLen = j - start + 1;
                if (minLen > windowLen) {
                    minLen = windowLen;    // Nayi sabse choti lambai save kar lo
                    startIndex = start;    // Answer kahan se shuru hota hai wo index save kar lo
                }
            }
        }

        // Agar koi window nahi mili
        if (startIndex == -1) {
            return "";
        }
        
        // Final answer string me se nikal kar de do
        return str.substring(startIndex, startIndex + minLen);
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pat = "ABC";
        
        System.out.println("Smallest window is: " + minWindow(str, pat)); 
        // Output aayega: "BANC"
    }
}