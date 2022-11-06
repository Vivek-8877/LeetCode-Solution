// Problem Link :- https://leetcode.com/problems/orderly-queue/description/
// Video Solution Link :- https://youtu.be/aejgJ6MZvM0

class Solution {
    // Time Complexity : O(n.log(n));
    public String orderlyQueue(String s, int k) {
        if(k==1) {
            String ans =s;
            for(int i=0;i<s.length();i++) {
                s = s.substring(1)+s.substring(0,1);
                if(ans.compareTo(s)>0) ans =s;
            }
            return ans;
        } else {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }
}
