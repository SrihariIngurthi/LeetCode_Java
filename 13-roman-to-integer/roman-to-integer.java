class Solution {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int number = 0;
        int i = 0;
        int n = ch.length;
        while(i < n){
        if(ch[i] == 'I'){
            number += 1;
            i++;
            if(i != n && ch[i] == 'V') {
                number += 3;
                i++;
            } else if(i != n && ch[i] == 'X'){
                number += 8;
                i++;
            } 
        } else if(ch[i] == 'V') {
            number += 5;
            i++;
        } else if(ch[i] == 'X') {
            number += 10;
            i++;
            if(i != n && ch[i] == 'L'){
                number += 30;
                i++;
            } else if(i != n && ch[i] == 'C') {
                i++;
                number += 80;
            }
        } else if(ch[i] == 'L') {
            number += 50;
            i++;
        } else if(ch[i] == 'C') {
            number += 100;
            i++;
            if(i != n && ch[i] == 'D') {
                number += 300;
                i++;
            } else if(i != n && ch[i] == 'M') {
                number += 800;
                i++;
            }
        } else if(ch[i] == 'D') {
            number += 500;
            i++;
        } else {
            number += 1000;
            i++;
        }
        }
        return number;
    }
}