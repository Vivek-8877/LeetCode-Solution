// Problem Link :- https://leetcode.com/problems/orderly-queue/description/
// Video Solution Link :- https://youtu.be/aejgJ6MZvM0

class Solution {
public:
    // Time Complexity : O(n.log(n));
    
    string orderlyQueue(string s, int k) {
        if(k==1) {
            string ans =s;
            for(int i=0;i<s.length();i++) {
                s = s.substr(1)+s.substr(0,1);
                if(ans>s) ans =s;
            }
            return ans;
        } else {
            sort(s.begin(),s.end());
            return s;
        }
    }
};
