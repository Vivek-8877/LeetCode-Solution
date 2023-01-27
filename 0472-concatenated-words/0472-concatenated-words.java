class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String word : words) {
            set.add(word);
        }
        for(String word : words) {
            if(isValid(set,word,0,new Boolean[word.length()])) list.add(word);
        }
        return list;
    }
    
    public static boolean isValid(HashSet<String> set,String s,int idx,Boolean[] dp) {
        if(idx>=s.length()) return true;
        if(dp[idx]!=null) return dp[idx];
        boolean ans = false;
        for(int i=idx;i<s.length() && !ans;i++) {
            if(idx==0 && i==s.length()-1) continue;
            if(set.contains(s.substring(idx,i+1)) && isValid(set,s,i+1,dp)) ans=true;
        }
        return dp[idx]=ans;
    }
}