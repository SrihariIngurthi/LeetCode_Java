class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int i = 0;
        int maz1 = Integer.MIN_VALUE;
        int maz2 = Integer.MIN_VALUE;

        while(i < n){
            if(maz1 < nums[i]){
                maz2 = maz1;
                maz1 = nums[i];
            } else if(maz2 < nums[i]){
                maz2 = nums[i];
        }
            i++;
        }
        return (maz1 - 1) * (maz2 - 1);
    }
}