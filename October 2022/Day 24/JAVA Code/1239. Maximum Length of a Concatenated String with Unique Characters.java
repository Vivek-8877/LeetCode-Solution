// T.C :- O(2^n)

class Solution {
    public int maxLength(List<String> arr) {
        int ans =0;
        for(int i=1;i<(1<<arr.size());i++) {
            int[] f = new int[26];
            boolean isValid=true;
            int total_size=0;
            for(int j=0;j<=arr.size() && isValid;j++) {
                if(isSet(i,j)) {
                    total_size+=arr.get(j).length();
                    for(int k=0;k<arr.get(j).length() && isValid;k++) {
                        int idx = arr.get(j).charAt(k)-'a';
                        if(f[idx]==0) {
                            f[idx]++;
                        } else {
                            isValid=false;
                        }
                    }
                }
            }
            if(isValid) ans = Math.max(ans,total_size);
        }
        return ans;
    }
    
    public static boolean isSet(int n,int idx) {
        return (n&(1<<idx))!=0;
    }
}
