class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length < 2) return nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        if(nums[0] != nums[1]) return nums[0];

        for(int i = 1; i < nums.length; i = i + 2) {
            int j = i - 1;
            if(nums[j] != nums[i]) {
                if(nums[j] != nums[j - 1])
                    return nums[j];
                else return nums[i];
            }
        }
        return 0;
    }
}