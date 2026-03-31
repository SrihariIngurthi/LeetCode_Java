class Solution {
    public String generateString(String str1, String str2) {
      int x = str1.length();  
      int y = str2.length();
      int len = x+y-1;
      char[] res = new char[len];
      boolean[] lock = new boolean[len];
      for(int i = 0;i<len;i++) res[i] = 'a';
      for(int i = 0;i<x;i++){
        if(str1.charAt(i) == 'T'){
            for(int j = 0;j<y;j++){
                int p = i+j;
                if(p >= len) return "";
                if(lock[p] && res[p] != str2.charAt(j)) return "";
                res[p] = str2.charAt(j);
                lock[p] = true;
            }
        }
      }  
      for(int i =0;i<x;i++){
        if(str1.charAt(i) == 'F'){
            boolean same = true;
            for(int j = 0; j<y;j++){
                if(res[i+j] != str2.charAt(j)){
                    same = false;
                    break;
                }
            }
            if(same){
                boolean changed = false;
                for(int j = y-1;j >=0; j--){
                    int p = i+j;
                    if(!lock[p]){
                        res[p] = 'b';
                        changed = true;
                        break;
                    }
                }
                if(!changed) return "";
            }
        }
      }
      return new String(res);
    }
}