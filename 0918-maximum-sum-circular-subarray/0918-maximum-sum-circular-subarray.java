class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=Integer.MIN_VALUE;
        int maxsum=0;
        int min = Integer.MAX_VALUE;
        int minsum=0;
        int sum=0;
        for(int n : nums) {
            maxsum+=n;
            minsum+=n;
            sum+=n;
            // System.out.println(maxsum);
            if(max<maxsum) max=maxsum;
            if(min>minsum) min=minsum;
            if(maxsum<0) maxsum=0;
            if(minsum>0) minsum=0;
        }
        // System.out.println(max+" "+min+" "+sum);
        if(sum==min) {
            return max;
        } else {
            return Math.max(sum-min,max);
        }
    }
}