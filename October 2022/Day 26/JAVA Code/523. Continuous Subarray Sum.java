class Solution {
    public boolean checkSubarraySum(int[] nums, long k) {
        HashMap<Long,Integer> map = new HashMap<>();
        long sum=0;
        map.put(sum,-1);
        for(int i=0;i<nums.length;i++) {
            long num = nums[i];
            sum = ((sum%k)+(num%k))%k;
            if(map.containsKey(sum)) {
                if(map.get(sum)!=i-1) return true;
            } else {
                map.put(sum,i);
            }
        }
        return false;
    }
}
