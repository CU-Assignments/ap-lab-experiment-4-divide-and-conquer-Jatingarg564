import java.util.*;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = constructBeautifulArray(n);
        int[] beautiful = new int[n];
        for (int i = 0; i < n; i++) {
            beautiful[i] = result.get(i);
        }
        return beautiful;
    }

    private List<Integer> constructBeautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(1);
            return result;
        }

        // Get the left part (odd numbers)
        List<Integer> oddPart = constructBeautifulArray((n + 1) / 2);
        // Get the right part (even numbers)
        List<Integer> evenPart = constructBeautifulArray(n / 2);

        // Map to the actual values
        for (int x : oddPart) {
            result.add(2 * x - 1);  // Odd transformation
        }
        for (int x : evenPart) {
            result.add(2 * x);      // Even transformation
        }

        return result;
    }
}
