class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,1);
        int ans=0;
        for(int num : nums) {
            sum = ((sum%k)+(num%k)+k)%k;
            if(map.containsKey(sum)) {
                ans+=map.get(sum);
                map.put(sum,map.get(sum)+1);
            } else {
                map.put(sum,1);
            }
        }
        return ans;
    }
}