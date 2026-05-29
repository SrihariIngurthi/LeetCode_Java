class Solution {
    private int Sum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = 9999;
        for(int i = 0; i < n; i++){
            min = Math.min(min, Sum(nums[i]));
        }
        return min;
    }
}