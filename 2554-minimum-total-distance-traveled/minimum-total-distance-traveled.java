class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int n = robot.size();
        int m = factory.length;
        long[][] dp = new long[n+1][m+1];
        for(long[] row: dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][0] = 0;
        for(int j = 1; j<=m;j++){
            dp[0][j] = 0;
            for(int i = 1;i<=n;i++){
                dp[i][j] = dp[i][j-1];
                long distance = 0;
                for(int k = 1;k<=Math.min(factory[j-1][1], i); k++){
                    distance += Math.abs(robot.get(i-k) - factory[j-1][0]);
                    if(dp[i-k][j-1] != Long.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j], dp[i-k][j-1] + distance);
                    }
                }
            }
        } 
        return dp[n][m];
    }
}