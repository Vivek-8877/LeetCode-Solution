class Solution {
    // Time Complexity :- O(m*n*log(min(m,n)));
    public int findLength(int[] nums1, int[] nums2) {
        int lo=0,hi=Math.min(nums1.length,nums2.length);
        int ans=0;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(isValid(nums1,nums2,mid)) {
                lo=mid+1;
                ans = Math.max(ans,mid);
            } else {
                hi=mid-1;
            }
        }
        return ans;
    }
    
    public static boolean isValid(int[] n1,int[] n2,int l) {
        // Time Complexity :- O(m*n);
        for(int i=0;i<=n1.length-l;i++) {
            for(int j=0;j<=n2.length-l;j++) {
                boolean valid = true;
                for(int k=0;k<l && valid;k++) {
                    if(n1[i+k]!=n2[j+k]) {
                        valid=false;
                    }
                }
                if(valid)  return true;
            }
        }
        return false;
    }
    
}
