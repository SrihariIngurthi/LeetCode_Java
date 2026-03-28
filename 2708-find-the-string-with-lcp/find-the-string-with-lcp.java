class Solution {
    public String findTheString(int[][] lcp) {
       int n = lcp.length;
       char[] res = new char[n];
       for(int i = 0;i<n;i++) res[i] = '?';
       char ch = 'a';
       for(int i = 0;i<n;i++){
        if(res[i] == '?'){
            if(ch > 'z') return "";
            for(int j = i;j<n;j++){
                if(lcp[i][j] > 0){
                    res[j] = ch;
                }
            }
            ch++;
        }
       } 
       int [][] dp = new int[n][n];
       for(int i = n-1;i>=0;i--){
        for(int j = n-1;j>=0;j--){
            if(res[i] == res[j]){
                dp[i][j] = 1+((i+1<n && j+1 < n) ? dp[i+1][j+1] : 0);
            }
            if(dp[i][j] != lcp[i][j]) return "";
        }
       }
       return new String(res);
    }
}