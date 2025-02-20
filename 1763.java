class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return ""; // Base case: No nice substring possible

        // Step 1: Create a set of all characters in the string
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        // Step 2: Find the first "bad" character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toUpperCase(c)) || !set.contains(Character.toLowerCase(c))) {
                // Step 3: Split and recursively find the longest nice substring
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }

        // If no bad character is found, the entire string is nice
        return s;
    }
}
