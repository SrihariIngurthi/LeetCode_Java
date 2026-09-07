class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numbers1 = new HashSet<Integer>();
        Set<Integer> join = new HashSet<Integer>();

        for(int i = 0; i < nums1.length; i++) {
            numbers1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if(numbers1.contains(nums2[j])) {
                join.add(nums2[j]);
            }
        }
        int[] result = new int[join.size()];
        int index = 0;
        for (int num : join) {
            result[index++] = num;
        }
        return result;
    }
}