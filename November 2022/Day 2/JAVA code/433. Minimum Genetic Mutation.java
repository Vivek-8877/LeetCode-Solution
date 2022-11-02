Problem Link :- https://leetcode.com/problems/minimum-genetic-mutation/
Video Solution Link :- https://www.youtube.com/watch?v=fBNrFBPpejU

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        return f(start,end,bank,new byte[bank.length]);
    }
    
    public static int f(String start,String end,String[] bank,byte[] visit) {
        if(start.compareTo(end)==0) return 0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<bank.length;i++) {
            if(visit[i]==0) {
                int ct=0;
                for(int j=0;j<start.length();j++) {
                    if(start.charAt(j)!=bank[i].charAt(j)) {
                        ct++;
                    }
                }
                if(ct<2) {
                    visit[i]=1;
                    int val = f(bank[i],end,bank,visit);
                    if(val!=-1) ans = Math.min(ans,val+1);
                    visit[i]=0;
                }
            }
        }
        if(ans==Integer.MAX_VALUE) ans=-1;
        return ans;
    }
}
