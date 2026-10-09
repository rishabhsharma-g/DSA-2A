public class DSA5 {
    
    public static int findEquilibrium(int[] arr) {
        int totalSum = 0; // Poore array ka sum
        int leftSum = 0;  // Left side ka sum
        
        // Step 1: Array ke saare numbers ko jod kar totalSum nikal lo
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        
        // Step 2: Ek-ek karke har index par check karo
        for (int i = 0; i < arr.length; i++) {
            // Current number ko totalSum se ghata do, 
            // taaki bacha hua 'totalSum' ab right side ka sum ban jaye
            totalSum -= arr[i]; 
            
            // Check karo ki kya left side ka sum aur right side ka sum barabar hai?
            if (leftSum == totalSum) {
                return i; // Agar barabar hai, toh yahi humara equilibrium index hai!
            }
            
            // Agle index ke liye, is current number ko leftSum mein jod do
            leftSum += arr[i];
        }
        
        // Agar poore array mein koi equilibrium index nahi mila
        return -1;
    }

    // Test karne ke liye main method
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        
        int index = findEquilibrium(arr);
        System.out.println("Equilibrium index is: " + index); 
        // Output aayega: 3 (Kyunki index 3 ke left ka sum -1 hai aur right ka sum bhi -1 hai)
    }
}