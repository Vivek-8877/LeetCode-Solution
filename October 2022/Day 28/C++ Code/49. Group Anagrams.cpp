class Solution {
public:
    
    // Time Complexity :- O(n.m.log(n));
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n = strs.size();
        vector<pair<string,int>> s1;
        for(int i=0;i<n;i++) {
            pair<string,int> p(sortString(strs[i]),i);
            s1.push_back(p);
        }
        
        sort(s1.begin(),s1.end(),comp);
        
        vector<vector<string>> ans;
        vector<string> list;
        for(int i=0;i<n;i++) {
            list.push_back(strs[s1[i].second]);
            if(i!=n-1 && s1[i].first.compare(s1[i+1].first)!=0) {
                ans.push_back(list);
                list.clear();
            }
        }
        ans.push_back(list);
        return ans;
    }
    
    // Time Compleixty :- O(m)
    static bool comp(const pair<string,int>& p1,const pair<string,int>& p2) {
        return p1.first<p2.first;
    }
    
    // Time Complexity :- O(m.log(m))
    string sortString(string str) {
        sort(str.begin(),str.end());
        return str;
    }
    
};
