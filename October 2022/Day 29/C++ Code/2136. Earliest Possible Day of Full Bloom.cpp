class Solution {
public:
    // T.C :- O(n.log(n))
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        vector<pair<int,int>> a;
        for(int i=0;i<plantTime.size();i++) {
            pair<int,int> p(plantTime[i],growTime[i]);
            a.push_back(p);
        }
        
        sort(a.begin(),a.end(),comp);
        
        int ans=0;
        int worked_day=0;
        for(int i=0;i<a.size();i++) {
            worked_day+=a[i].first;
            ans = max(ans,worked_day+a[i].second);
        }
        
        return ans;
    }
    
    static bool comp(const pair<int,int>& p1,const pair<int,int>& p2) {
        return p1.second>p2.second;
    }
};
