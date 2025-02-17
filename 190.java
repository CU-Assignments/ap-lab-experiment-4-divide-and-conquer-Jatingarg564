public class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Get the last bit of n (n & 1)
            int bit = n & 1;

            // Left shift the result and add the extracted bit
            result = (result << 1) | bit;

            // Right shift n to process the next bit
            n >>= 1;
        }

        return result;
    }
}
