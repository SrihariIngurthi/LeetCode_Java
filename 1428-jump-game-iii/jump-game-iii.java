class Solution {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] < 0){
            return false;
        } 
        if(arr[start] == 0){
            return true;
        }
        int jumpdistance = arr[start];
        arr[start] = -1;
        return canReach(arr, start + jumpdistance) || canReach(arr, start - jumpdistance);
    }
}