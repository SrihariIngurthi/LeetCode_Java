class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int [][][] dp = new int[k+1][grid.length+1][grid[0].length + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                for(int p = 0; p < dp[0][0].length; p++){
                    dp[i][j][p] = -1;
                }
            }
        }

        int ans = solve(grid, k, 0, 0, dp);
        if(ans < 0){
            return -1;
        }
        return ans;

    }
    public int solve(int[][] grid,int k, int i, int j, int[][][] dp){
        if(dp[k][i][j] != -1){
            return dp[k][i][j];
        }
        if(i == grid.length || j == grid[0].length){
            return dp[k][i][j] = Integer.MIN_VALUE;
        }
        if(k == 0 && grid[i][j] != 0){
            return dp[k][i][j] = Integer.MIN_VALUE;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(grid[i][j] == 0) return dp[k][i][j] = grid[i][j] + Math.max(solve(grid, k,i, j + 1, dp), solve(grid, k, i+1, j, dp));
        return dp[k][i][j] = grid[i][j] + Math.max(solve(grid, k -1,i,j+1,dp), solve(grid,k-1,i+1,j,dp));
    }
}