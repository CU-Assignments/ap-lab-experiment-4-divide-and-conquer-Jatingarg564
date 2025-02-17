class Solution {
    // Modulus value as per the problem
    private static final int MOD = 1337;
    
    // Main function to calculate a^b % 1337
    public int superPow(int a, int[] b) {
        a %= MOD;  // Reduce the base to modulo 1337
        int result = 1;

        // Process each digit from right to left
        for (int i = 0; i < b.length; i++) {
            result = (powMod(result, 10) * powMod(a, b[i])) % MOD;
        }
        
        return result;
    }

    // Function to calculate (x^y) % MOD using modular exponentiation
    private int powMod(int x, int y) {
        int res = 1;
        x %= MOD;  // Ensure x is within mod range
        
        while (y > 0) {
            if ((y & 1) == 1) { // If y is odd, multiply the result
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD; // Square the base
            y >>= 1;           // Divide y by 2
        }
        
        return res;
    }
}
