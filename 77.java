import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // Base case: if we have a valid combination of length k
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through possible numbers
        for (int i = start; i <= n; i++) {
            // Choose the current number
            current.add(i);

            // Explore further combinations
            backtrack(result, current, i + 1, n, k);

            // Undo the last choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
