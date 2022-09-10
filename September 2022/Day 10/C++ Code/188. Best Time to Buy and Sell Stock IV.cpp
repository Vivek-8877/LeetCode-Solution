class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        vector<vector<vector<int>>> dp(k+1,vector<vector<int>>(prices.size(),vector<int>(2,-1)));
        return solve(prices,0,k,0,dp);
    }
    
    int solve(vector<int>& prices,int i,int k,int status,vector<vector<vector<int>>>& dp) {
        if(i>=prices.size() || k<=0) return 0;
        
        if(dp[k][i][status]!=-1) {
            return dp[k][i][status];
        }
        
        int ans =0;
        if(status==0) {
            int v1 = solve(prices,i+1,k,1,dp);
            int v2 = solve(prices,i+1,k,status,dp);
            ans=max(v1-prices[i],v2);
        } else {
            int v1 = solve(prices,i+1,k-1,0,dp);
            int v2 = solve(prices,i+1,k,status,dp);
            ans=max(v1+prices[i],v2);
        }
        
        return dp[k][i][status]=ans;
    }
};
