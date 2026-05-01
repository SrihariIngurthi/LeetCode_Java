class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int f = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            f += i * nums[i];
            sum += nums[i];
        }
        int max = f;
        for(int i = 1;i < n; i++){
            f = f + sum - n * nums[n - i];
            if(max < f){
                max = f;
            } 
        }
        return max;
    }
}