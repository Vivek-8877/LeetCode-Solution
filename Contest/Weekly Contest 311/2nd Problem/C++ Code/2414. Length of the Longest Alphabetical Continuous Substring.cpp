class Solution {
public:
    int longestContinuousSubstring(string s) {
        int ans=1;
        int f=1;
        for(int i=0;i<s.length()-1;i++) {
            if(s[i]==s[i+1]-1) {
                f++;
            } else {
                ans = max(ans,f);
                f=1;
            }
            if(ans==26) return 26;
        }
        ans = max(ans,f);
        return ans;
    }
};
