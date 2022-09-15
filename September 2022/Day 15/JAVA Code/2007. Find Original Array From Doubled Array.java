class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2==1) return new int[0];
        Arrays.sort(changed);
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val : changed) add(map,val);
        
        int[] ans = new int[n/2];
        int j=0;
        for(int val : changed) {
            if(val==0) {
                if(map.containsKey(0) && map.get(0)>=2) {
                    ans[j]=0;
                    j++;
                    remove(map,0);
                    remove(map,0);
                }
            } else {
                if(map.containsKey(val) && map.containsKey(val*2)) {
                    ans[j]=val;
                    j++;
                    remove(map,val);
                    remove(map,val*2);
                }
            }
        }
        if(j<n/2) return new int[0];
        return ans;
    }
    
    public static void add(HashMap<Integer,Integer> map,int key) {
        if(map.containsKey(key)) {
            map.put(key,map.get(key)+1);
        } else {
            map.put(key,1);
        }
    }
    
    public static void remove(HashMap<Integer,Integer> map,int key) {
        if(map.get(key)==1) {
            map.remove(key);
        } else {
            map.put(key,map.get(key)-1);
        }
    }
}
