class Solution {
    public int maxDistance(int[] colors) {
       int n = colors.length;
       int max = 0;
       for(int i = 0;i<n;i++){
        for(int j = 0;j<n;j++){
            if(colors[i] != colors[j]){
                max = Math.max(max, Math.abs(j-i));
            }
        }
       } 
       return max;
    }
}