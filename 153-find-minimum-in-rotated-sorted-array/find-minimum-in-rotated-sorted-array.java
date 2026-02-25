class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = nums[0];
        for(int i = 0;i<n;i++){
            if(nums[i]<low){
                low = nums[i];
            }
        }
        return low;
    }
}