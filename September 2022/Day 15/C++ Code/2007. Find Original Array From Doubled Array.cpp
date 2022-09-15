class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        int n = changed.size();
        if(n%2==1) {
            vector<int> ans;
            return ans;
        }
        sort(changed.begin(),changed.end());
        
        vector<int> fre(100002,0);
        for(int val : changed) fre[val]++;
        
        vector<int> ans;
        for(int val : changed) {
            if(val==0) {
                if(fre[0]>=2) {
                    ans.push_back(0);
                    fre[0]-=2;
                }
                continue;
            }
            if(fre[val]>0) {
                if(val*2<100002 && fre[val*2]>0) {
                    ans.push_back(val);
                    fre[val]--;
                    fre[val*2]--;
                }
            }
        }
        if(ans.size()<n/2) {
            vector<int> a1;
            return a1;
        }
        return ans;
    }
};
