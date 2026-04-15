class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = n;
        for(int i = 0;i < n; i++){
            if(words[i].equals(target)){
            int diff = Math.abs(i - startIndex);
            int currentDistance = Math.min(diff, n - diff);
            minDistance = Math.min(minDistance, currentDistance);
        }
    }
    return (minDistance == n) ? -1 : minDistance;
}
}