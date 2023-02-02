class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        boolean ans=true;
        int[] p1 = new int[26];
        for(int i=0;i<26;i++) {
            p1[order.charAt(i)-'a']=i;
        }
        
        for(int i=0;i<words.length-1 && ans;i++) {
            if(!isSmaller(words[i],words[i+1],p1)) {
                // System.out.println(i);
                ans=false;
            }
        }
        
        return ans;
    }
    
    public static boolean isSmaller(String s1,String s2,int[] p1) {
        for(int i=0;i<s1.length() && i<s2.length();i++) {
            if(p1[s1.charAt(i)-'a']>p1[s2.charAt(i)-'a']) {
                // System.out.println(i+" <--");
                return false;
            } else if(p1[s1.charAt(i)-'a']<p1[s2.charAt(i)-'a']) {
                return true;
            }
        }
        if(s1.length()>s2.length()) return false;
        return true;
    }
}