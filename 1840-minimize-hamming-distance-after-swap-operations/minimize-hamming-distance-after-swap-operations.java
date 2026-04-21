import java.util.*;
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for(int [] swap : allowedSwaps){
            uf.union(swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> components = new HashMap<>();
        for(int i = 0;i<n;i++){
            int root = uf.find(i);
            components.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> map = components.get(root);
            map.put(source[i], map.getOrDefault(source[i], 0) + 1);
        }
        int distance = 0;
        for(int i = 0;i<n;i++){
            int root = uf.find(i);
            Map<Integer, Integer> map = components.get(root);
            if(map.getOrDefault(target[i], 0) > 0){
                map.put(target[i], map.get(target[i]) - 1);
            } else {
                distance++;
            }
        }
        return distance;
    }
    class UnionFind{
        int [] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0;i<n;i++) parent[i] = i;
        }
        public int find(int i){
            if(parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI != rootJ) parent[rootI] = rootJ;
        }
    }
}