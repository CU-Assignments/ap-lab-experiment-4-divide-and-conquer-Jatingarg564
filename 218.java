import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        // Store all critical points: (x, height)
        List<int[]> points = new ArrayList<>();
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]}); // Start point (negative height for sorting)
            points.add(new int[]{b[1], b[2]});  // End point (positive height)
        }

        // Sort points by x-coordinate; If tie, process 'start' before 'end'
        Collections.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        // Max heap to store active buildings
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); // Sentinel value to avoid empty heap
        int prevMaxHeight = 0;

        // Process all sorted points
        for (int[] point : points) {
            int x = point[0], height = point[1];

            if (height < 0) {
                // Start point: Add height to the heap
                maxHeap.add(-height);
            } else {
                // End point: Remove height from the heap
                maxHeap.remove(height);
            }

            // Current max height
            int currentMaxHeight = maxHeap.peek();
            // If the max height changes, it's a critical point
            if (currentMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }

        return result;
    }
}
