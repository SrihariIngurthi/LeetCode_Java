class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int idx = -1;
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();
    
    private void insert(String word, int index) {
        TrieNode node = root;
        int n = word.length();

        if(n < node.len) {
            node.len = n;
            node.idx = index;
        }

        for(int i = n - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            if(n < node.len) {
                node.len = n;
                node.idx = index;
            }
        }
    }

    private int search(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int [] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}