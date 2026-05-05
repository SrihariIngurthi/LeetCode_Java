class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            int m = nums[i];
            int digit = 0;
            while(m > 0){
                m = m/10;
                digit++;
            }
            if(digit % 2 == 0) count++;
        }
        return count;
    }
}