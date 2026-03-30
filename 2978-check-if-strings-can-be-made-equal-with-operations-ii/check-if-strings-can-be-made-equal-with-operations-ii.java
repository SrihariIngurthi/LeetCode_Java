class Solution {
    public boolean checkStrings(String s1, String s2) {
      int [][] freq = new int[2][26];
      int n = s1.length();
      for(int i = 0;i < n;i++){
        freq[i % 2][s1.charAt(i) - 'a']++;
        freq[i % 2][s2.charAt(i) - 'a']--;
      }
      for(int i = 0;i<26;i++){
        if(freq[0][i] != 0 || freq[1][i] != 0){
            return false;
        }
      }  
      return true;
    }
}