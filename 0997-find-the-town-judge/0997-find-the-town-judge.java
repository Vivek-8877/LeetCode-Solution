class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<Integer>[] a = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            a[i] = new ArrayList<>();
        }
        int[] c = new int[n+1];
        for(int[] b : trust) {
            a[b[1]].add(b[0]);
            c[b[0]]=b[1];
        }
        for(int i=1;i<=n;i++) {
            Set<Integer> set = new HashSet<>();
            // System.out.println(i+" "+a[i]);
            if(a[i].size()==n-1) {
                for(int v : a[i]) {
                    set.add(v);
                }
                // System.out.println(set);
                if(set.size()==n-1 && c[i]==0) return i;
            }
        }
        return -1;
    }
}