class Solution {
    public static int tribonacc(int n,int[] dp) {
    if(n<=0) {
            return dp[0];
        } else if(n==1 || n==2) {
            return dp[1];
        }
        if(dp[n]!=0) {
            return dp[n];
        }
        dp[n] =tribonacc(n-1,dp)+tribonacc(n-2,dp)+tribonacc(n-3,dp);
        return dp[n];
        }
    public int tribonacci(int n) {
        int[] dp = new int[40];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
     tribonacc(n,dp);
        return dp[n];
    }
}