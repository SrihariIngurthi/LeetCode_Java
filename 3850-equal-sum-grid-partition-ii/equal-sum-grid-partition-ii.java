class Solution {
    public boolean canPartitionGrid(int[][] grid) {
       if(check(grid)) return true;
       return check(transpose(grid)); 
    }
    private boolean check(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        int [] botCount = new int[100001];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                totalSum += grid[i][j];
                botCount[grid[i][j]]++;
            }
        }
        long topSum = 0;
        int [] topCount = new int[100001];
        for(int i =0;i<m-1;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                topSum += val;
                topCount[val]++;
                botCount[val]--;
            }
            long botSum = totalSum - topSum;
            if(topSum == botSum) return true;
            long diffTop = topSum - botSum;
            if(diffTop > 0 && diffTop <= 100000 && topCount[(int)diffTop] > 0){
                if(isSafe(grid, i + 1, n, (int)diffTop, 0, i, 0, n-1)) return true;
            }
            long diffBot = botSum - topSum;
            if(diffBot > 0 && diffBot <= 100000 && botCount[(int)diffBot] > 0){
                if(isSafe(grid, m-(i+1), n,(int)diffBot, i+1,m-1,0,n-1)) return true;
            }
        }
        return false;
    }
    private boolean isSafe(int[][] grid,int rows,int cols, int val,int r1,int r2,int c1,int c2){
        if(rows > 1 && cols > 1) return true;
        if(rows == 1){
            return grid[r1][c1] == val || grid[r1][c2] == val;
        }
        if(cols == 1){
            return grid[r1][c1] == val || grid[r2][c1] == val;
        }
        return false;
    }
    private int[][] transpose(int [][] grid){
        int m = grid.length, n = grid[0].length;
        int [][] res = new int[n][m];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++) res[j][i] = grid[i][j];
        }
        return res;
    }
}