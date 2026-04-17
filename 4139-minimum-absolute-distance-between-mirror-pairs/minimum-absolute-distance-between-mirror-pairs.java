class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        for(int j = 0;j < nums.length;j++){
            if(map.containsKey(nums[j])){
                int i = map.get(nums[j]);
                minDist = Math.min(minDist, j - i);
            }
            int rev = reverse(nums[j]);
            map.put(rev, j);
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    private int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
}

