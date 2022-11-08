class Solution {
public:
    // Time Complexity :- O(n);
    // Space Complexity :- O(n);

    string makeGood(string s) {
        stack<char> stk;
        int idx =0;
        while(idx<s.length()) {
            char c = s[idx++];
            if(stk.size()>0) {
                char p = stk.top();
                if(isValid(c,p)) {
                    stk.push(c);
                } else {
                    stk.pop();
                }
            } else {
                stk.push(c);
            }
        }
        string ans ="";
        while(stk.size()>0) {
            ans+=stk.top();
            stk.pop();
        }
        string ans1="";
        for(int i=ans.length()-1;i>=0;i--) ans1+=ans[i];
        return ans1;
    }

    bool isValid(char c,char p) {
        if(c>='A' && c<='Z') {
            if(p>='a' && p<='z' && p-'a'==c-'A') {
                return false;
            }
        } else {
            if(p>='A' && p<='Z' && p-'A'==c-'a') {
                return false;
            }
        }
        return true;
    }
};
