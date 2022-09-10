class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[k+1][prices.length][2];
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[i].length;j++) {
                for(int l=0;l<dp[i][j].length;l++) dp[i][j][l]=-1;
            }
        }
        
        return solve(prices,0,k,0,dp);
    }
    
    public int solve(int[] prices,int i,int k,int status,int[][][] dp) {
        if(i>=prices.length || k<=0) return 0;
        
        if(dp[k][i][status]!=-1) return dp[k][i][status];
        
        int ans =0;
        if(status==0) {
            int v1 = solve(prices,i+1,k,1,dp);
            int v2 = solve(prices,i+1,k,status,dp);
            ans=Math.max(v1-prices[i],v2);
        } else {
            int v1 = solve(prices,i+1,k-1,0,dp);
            int v2 = solve(prices,i+1,k,status,dp);
            ans=Math.max(v1+prices[i],v2);
        }
        
        return dp[k][i][status]=ans;
    }
    
}
