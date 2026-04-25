import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] d = new long[n];
        long totalPerimeter = 4L * side;

        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) d[i] = x;
            else if (x == side) d[i] = (long) side + y;
            else if (y == side) d[i] = 2L * side + (side - x);
            else d[i] = 3L * side + (side - y);
        }
        Arrays.sort(d);

        long[] circle = new long[2 * n];
        for (int i = 0; i < n; i++) {
            circle[i] = d[i];
            circle[i + n] = d[i] + totalPerimeter;
        }

        int low = 1, high = (int) (totalPerimeter / k);
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(circle, n, mid, k, totalPerimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(long[] circle, int n, int dist, int k, long totalPerimeter) {
        for (int i = 0; i < n; i++) {
            if (circle[i] > circle[0] + dist) break;

            int count = 1;
            int currIdx = i;
            long firstPos = circle[i];
            
            for (int j = 1; j < k; j++) {
                int nextIdx = lowerBound(circle, currIdx + 1, i + n - 1, circle[currIdx] + dist);
                if (nextIdx == -1 || nextIdx >= i + n) {
                    count = -1;
                    break;
                }
                currIdx = nextIdx;
                count++;
            }

            if (count == k && (firstPos + totalPerimeter - circle[currIdx]) >= dist) {
                return true;
            }
        }
        return false;
    }

    private int lowerBound(long[] arr, int left, int right, long target) {
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}