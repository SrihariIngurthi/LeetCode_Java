import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for(int i = 0;i<n;i++){
            indices.computeIfAbsent(nums[i] , k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> idx : indices.values()){
            if(idx.size() < 3) continue;
            for(int i = 0;i + 2 < idx.size(); i++){
                int dist = 2*(idx.get(i+2) - idx.get(i));
                minDist = Math.min(minDist , dist);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}