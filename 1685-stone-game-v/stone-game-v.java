class Solution {
    int [] sum;
    Integer[][] dp;
    public int rec(int[] arr, int left,int right) {
        if (left == right) {
            return 0;
        }
        if(dp[left][right] != null)
            return dp[left][right];
        int max = 0;
        for (int i = left; i < right; i++){
            int l = sum[i + 1] - sum[left];
            int r = sum[right + 1] - sum [i + 1];

            if ( l > r) {
                max = Math.max(max, r + rec(arr,i + 1, right));
            }
            else  if(r > l) {
                max = Math.max(max, l + rec(arr, left, i));
            } else {
                max = Math.max(max, r+ rec(arr,i + 1, right));
                max = Math.max(max, l + rec(arr, left, i));
            }
        }
        dp[left][right] = max;
        return max;
    }
    public int stoneGameV(int[] arr){
        sum = new int[arr.length + 1];
        dp = new Integer[arr.length][arr.length];
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            sum[i] = total;
            total += arr[i];
        }
        sum[arr.length] = total;
        return rec(arr, 0 ,arr.length - 1);
    }
}