class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int,int> mp;
        int sum =0;
        mp[0]=-1;
        for(int i=0;i<nums.size();i++) {
            sum=((sum%k)+(nums[i]%k))%k;
            if(mp.find(sum)!=mp.end()) {
                if(mp.find(sum)->second!=i-1) return true;
            } else {
                mp[sum]=i;
            }
        }
        return false;
    }
};
