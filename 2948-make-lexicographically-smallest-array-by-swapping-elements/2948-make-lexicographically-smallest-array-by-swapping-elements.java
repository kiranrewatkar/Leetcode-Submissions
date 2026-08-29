import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] sortedPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedPairs[i][0] = nums[i];
            sortedPairs[i][1] = i;
        }
        Arrays.sort(sortedPairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        List<int[]> currGroup = new ArrayList<>();
        currGroup.add(sortedPairs[0]);

        for (int i = 1; i < n; i++) {
            if (sortedPairs[i][0] - sortedPairs[i - 1][0] <= limit) {
                currGroup.add(sortedPairs[i]);
            } else {
                processGroup(currGroup, result);
                currGroup = new ArrayList<>();
                currGroup.add(sortedPairs[i]);
            }
        }
        processGroup(currGroup, result);

        return result;
    }

    private void processGroup(List<int[]> group, int[] result) {
        List<Integer> indices = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int[] p : group) {
            values.add(p[0]);
            indices.add(p[1]);
        }
        Collections.sort(indices);
        for (int i = 0; i < indices.size(); i++) {
            result[indices.get(i)] = values.get(i);
        }
    }
}