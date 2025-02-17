public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        // Loop through all 32 bits
        for (int i = 0; i < 32; i++) {
            // Check if the last bit is 1
            if ((n & 1) == 1) {
                count++;
            }
            // Right shift by 1 to check the next bit
            n >>= 1;
        }

        return count;
    }
}
