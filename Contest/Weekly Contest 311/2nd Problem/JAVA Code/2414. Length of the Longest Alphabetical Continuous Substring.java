class Solution {
    public int longestContinuousSubstring(String s) {
        int ans=1;
        int f=1;
        for(int i=0;i<s.length()-1;i++) {
            if(s.charAt(i)==s.charAt(i+1)-1) {
                f++;
            } else {
                ans = Math.max(ans,f);
                f=1;
            }
        }
        ans = Math.max(ans,f);
        return ans;
    }
}
