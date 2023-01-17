class Solution {
    public int minFlipsMonoIncr(String s) {
        int ct=0,ans=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') {
                ans++;
            } else {
                ct++;
            }
        }
        
        int ct1=0;
        for(int i=0;i<s.length();i++) {
            int a1 = ct1+ct;
            ans = Math.min(ans,a1);
            if(s.charAt(i)=='1') {
                ct1++;
            } else {
                ct--;
            }
        }
        return ans;
    }
}