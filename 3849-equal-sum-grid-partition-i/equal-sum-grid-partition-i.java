class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long sum = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                sum += grid[i][j];
            }
        }
        if(sum % 2 != 0) return false;
        long target = sum/2;
        long curr = 0;
        for(int i = 0;i<n;i++){
            long rowsum = 0;
            for(int j =0;j<m;j++){
                rowsum += grid[i][j];
            }
            curr += rowsum;
            if(curr == target) return true;
        }
        curr = 0;
        for(int j =0;j<m;j++){
            long colsum = 0;
            for(int i = 0;i<n;i++){
                colsum += grid[i][j];
            }
            curr += colsum;
            if(curr == target) return true;
        } 
        return false;
    }
}