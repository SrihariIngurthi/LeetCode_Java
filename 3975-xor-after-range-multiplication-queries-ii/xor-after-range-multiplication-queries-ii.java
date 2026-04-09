import java.util.*;
class Solution {
    private static final int MOD = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int sqrtN = (int)Math.sqrt(n);
        long[] finalMultipliers = new long[n];
        Arrays.fill(finalMultipliers, 1);
        Map<Integer, List<int[]>> smallKQueries = new HashMap<>();
        for(int[] q : queries){
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if(k > sqrtN){
                for(int i = l;i<=r;i+=k){
                    finalMultipliers[i] = (finalMultipliers[i] * v) % MOD;
                }
            } else {
                smallKQueries.computeIfAbsent(k, x -> new ArrayList<>()).add(q);
            }
        }
        long [] currentKDiff = new long[n + sqrtN +1];
        for(int k: smallKQueries.keySet()){
            Arrays.fill(currentKDiff, 1);
            for(int [] q : smallKQueries.get(k)){
                int l = q[0], r = q[1], v = q[3];
                currentKDiff[l] = (currentKDiff[l] * v) % MOD;
                int nextBeyondR = l + ((r-l)/ k+1)*k;
                if(nextBeyondR < n){
                    currentKDiff[nextBeyondR] = (currentKDiff[nextBeyondR] * modInverse(v, MOD)) % MOD;
                }
            }
            for(int i = 0;i<n;i++){
                if (i>= k){
                    currentKDiff[i] = (currentKDiff[i] * currentKDiff[i - k]) % MOD;
                }
                finalMultipliers[i] = (finalMultipliers[i] * currentKDiff[i]) % MOD;
            }
        }
        long totalXor = 0;
        for(int i = 0;i<n;i++){
            long finalVal = ((long)nums[i] * finalMultipliers[i]) % MOD;
            totalXor ^= finalVal;
        }
        return (int)totalXor;
    }
    private long modInverse(long n, int mod){
        return power(n, mod-2,mod);
    }
    private long power(long base, long exp, int mod){
        long res = 1;
        base %= mod;
        while(exp > 0){
            if(exp % 2 == 1) res = (res*base) % mod;
            base = (base*base) % mod;
            exp /= 2;
        }
        return res;
    }
}