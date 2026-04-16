class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int [] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i = 0;i<2*n;i++){
            int num = nums[i%n];
            if(hash.containsKey(num)){
                int prev = hash.get(num);
                int dis = i - prev;
                dist[i%n] = Math.min(dis,dist[i%n]);
                dist[prev%n] = Math.min(dis,dist[prev%n]);
            }
            hash.put(num,i);
        }
        for(int idx : queries){
            if(dist[idx] == Integer.MAX_VALUE || dist[idx] == n){
                ans.add(-1);
            }else{
                ans.add(dist[idx]);
            }
        }
        return ans;
    }
}