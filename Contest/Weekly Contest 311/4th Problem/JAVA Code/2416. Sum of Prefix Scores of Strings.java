class Solution {
    
    public static class TrieNode{
        TrieNode[] node;
        int count;
        TrieNode() {
            node = new TrieNode[26];
        }
    }
    
    public static void add(TrieNode root,String s) {
        for(int i=0;i<s.length();i++) {
            int idx = s.charAt(i)-'a';
            if(root.node[idx]==null) root.node[idx] = new TrieNode();
            root = root.node[idx];
            root.count++;
        }
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        
        for(String word : words) add(root,word);
        
        int[] ans = new int[words.length];
        for(int i=0;i<ans.length;i++) {
            ans[i] = find(words[i],root);
        }
        
        return ans;
    }
    
    public static int find(String s,TrieNode root) {
        int ans=0;
        for(int i=0;i<s.length();i++) {
            int idx = s.charAt(i)-'a';
            root=root.node[idx];
            ans+=root.count;
        }
        return ans;
    }
    
}
