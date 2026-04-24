class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int lc = 0;
        int rc = 0;
        for(int i = 0;i<n;i++){
            if(moves.charAt(i) == 'L') lc++;
            if(moves.charAt(i) == 'R') rc++;
        }
        if(rc > lc){
            return n - 2*lc;
        } else return n - 2 * rc;
    }
}