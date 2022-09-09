class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        sort(properties.begin(),properties.end(),[] (vector<int> &a, vector<int> &b){return b[0]>a[0];});
        
        int ans=0;
        int local_max = INT_MIN;
        int global_max = INT_MIN;
        
        for(int i=properties.size()-1;i>0;i--) {
            
            local_max = max(local_max,properties[i][1]);
            if(global_max>properties[i][1]) ans++;
            if(properties[i][0]!=properties[i-1][0]) {
                global_max = max(global_max,local_max);
                local_max = INT_MIN;
            }
            
        }
        
        if(global_max>properties[0][1]) ans++;
        return ans;
        
    }
};
