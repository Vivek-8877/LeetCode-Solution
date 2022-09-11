class Solution {
    public final long mod = 1000000007;
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int[][] a = new int[n][2];
        for(int i=0;i<n;i++) {
            a[i][0]=efficiency[i];
            a[i][1]=speed[i];
        }
        // In assending order according to efficiency or 0th index elements
        Arrays.sort(a,(b,c) -> (b[0]-c[0]));
        long ans=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // min - heap
        long sum=0;
        for(int i=n-1;i>=0;i--) {
            sum+=(long)(a[i][1]);
            pq.offer(a[i][1]);
            if(pq.size()>k) {
                sum-=(long)(pq.poll());
            }
            ans = Math.max(ans,sum*(long)a[i][0]);
        }
        return (int)(ans%mod);
    }
}
