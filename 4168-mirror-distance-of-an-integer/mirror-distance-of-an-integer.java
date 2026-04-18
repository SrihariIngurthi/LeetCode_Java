class Solution {
    public int mirrorDistance(int n) {
      int reversed = 0;
      int n1 = n;
      while(n1 != 0){
        int digit = n1 % 10;
        reversed = reversed * 10 + digit;
        n1 /= 10;
      }  
      return Math.abs(n - reversed);
    }
}