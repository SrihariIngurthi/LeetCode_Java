class Solution {
    public int[] maxValue(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int prefixMax = Integer.MIN_VALUE; 
        int suffixMin = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            ans[i] = prefixMax;
        } 

        for(int i = n - 1; i >= 0; i--) {

            if(ans[i] > suffixMin) {
                if(i + 1 < n) ans[i] = ans[i + 1];
            }

            suffixMin = Math.min(suffixMin, nums[i]);
        }

        return ans;
    }
}