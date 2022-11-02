// Problem Link :- https://leetcode.com/problems/minimum-genetic-mutation/
// Video Solution Link :- https://www.youtube.com/watch?v=fBNrFBPpejU

class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
        vector<int> visit(bank.size(),0);
        return f(start,end,bank,visit);
    }
    
    int f(string start,string end,vector<string>& bank,vector<int>& visit) {
        if(start==end) return 0;
        
        int ans=INT_MAX;
        for(int i=0;i<bank.size();i++) {
            if(visit[i]==0) {
                int ct=0;
                for(int j=0;j<start.length();j++) {
                    if(start[j]!=bank[i][j]) {
                        ct++;
                    }
                }
                if(ct<2) {
                    visit[i]=1;
                    int val = f(bank[i],end,bank,visit);
                    if(val!=-1) ans = min(ans,val+1);
                    visit[i]=0;
                }
            }
        }
        if(ans==INT_MAX) ans=-1;
        return ans;
    }
    
};
