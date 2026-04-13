class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDistance = n;
        int currDist = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == target){
                currDist = Math.abs(i - start);
            if(currDist < minDistance){
                minDistance = currDist;
            }
            if(minDistance == 0) return 0;
            } 
        }
        return minDistance;
    }
}