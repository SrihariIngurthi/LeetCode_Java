class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for(int val : nums){
            if(val < min) min = val;
            if(val > max) max = val;
        }
        return (long)(max - min)*k;
    }
}