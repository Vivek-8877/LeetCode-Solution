class Solution {
public:
    long long int mod=1000000007;
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        vector<vector<int>> a;
        
        for(int i=0;i<n;i++) {
            a.push_back(vector<int>{efficiency[i],speed[i]});
        }
        // In assending order
        sort(a.begin(),a.end(),[] (vector<int> &b, vector<int> &c){return c[0]>b[0];});
        
        
        long long int ans=0;
        priority_queue<int> pq; // max-heap
        long long sum=0;
        for(int i=n-1;i>=0;i--) {
            sum+=(a[i][1]);
            pq.push(-a[i][1]);  // to behave like as min heap we multiply elements by -1
            if(pq.size()>k) {
                sum+=pq.top();  // In place of subtracting we add because previously, we store elements by multiplying -1
                pq.pop();
            }
            ans = max(ans,sum*a[i][0]);
        }
        return (int)(ans%mod);
    }
};
