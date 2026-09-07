class Solution {
    public char findTheDifference(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        int sum1 = 0, sum2 = 0;

        for(int i = 0; i < ch1.length; i++)
            sum1 += ch1[i];
        for(int i = 0; i < ch2.length; i++)
            sum2 += ch2[i];

        return (char)(sum2 - sum1);
    }
}