class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
     int i = 0, j = 0;
     int l1 = nums1.length;
     int l2 = nums2.length;
     int max = 0;
     while(i < l1 && j < l2){
        if(nums1[i] <= nums2[j]){
            max = Math.max(max,j-i);
            j++;
        } else {
            i++;
        }
     }   
     return max;
    }
}