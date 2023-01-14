class Solution {
    public boolean isItPossible(String word1, String word2) {
        if(word1.length()==1 && word2.length()==1) return true;
        int[] f1 = frequency(word1);
        int[] f2 = frequency(word2);
        int c1=0,c2=0;
        for(int i=0;i<26;i++) {
            if(f1[i]>0) c1++;
            if(f2[i]>0) c2++;
        }
        
        return isValid(f1,f2,word2,c1,c2) || isValid(f2,f1,word1,c2,c1);
    }
    
    public static boolean isValid(int[] f1,int[] f2,String word2,int c1,int c2) {
        for(int i=0;i<26;i++) {
            if(f1[i]>0) {
                for(int j=0;j<word2.length();j++) {
                    int idx = word2.charAt(j)-'a';
                    int c11=c1,c22=c2;
                    f1[i]--;
                    f2[i]++;
                    
                    if(f1[i]==0) c11--;
                    if(f2[i]==1) c22++;
                    
                    f1[idx]++;
                    f2[idx]--;
                    
                    if(f1[idx]==1) c11++;
                    if(f2[idx]==0) c22--;
                    
                    f1[i]++;
                    f2[i]--;
                    f1[idx]--;
                    f2[idx]++;
                    
                    if(c11==c22) return true;
                }
            }
        }
        return false;
    }
    
    public static int[] frequency(String s) {
        int[] fre = new int[26];
        for(int i=0;i<s.length();i++) fre[s.charAt(i)-'a']++;
        return fre;
    }
}