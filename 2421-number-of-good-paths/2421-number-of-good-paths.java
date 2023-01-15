class Solution {
    
    public static int find(int[] a,int b) {
        if(a[b]<0) return b;
        int prnt = find(a,a[b]);
        a[b]=prnt;
        return prnt;
    }
    
    public static void union(int[] a,int b,int c) {
        int prntb = find(a,b);
        int prntc = find(a,c);
        // System.out.println(b+" "+c+" "+prntb+" "+prntc);
        if(prntb!=prntc) {
            a[prntc]+=a[prntb];
            a[prntb]=prntc;
        }
    }
    
    public static int nc2(int n) {
        if(n==1 || n==0) return 0;
        return (n*(n-1)/2);
    }
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for(int i=0;i<n;i++) {
            int val = vals[i];
            if(map.containsKey(val)) {
                List<Integer> list = map.get(val);
                list.add(i);
                map.put(val,list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(val,list);
            }
        }
        
        int[] connect = new int[n];
        Arrays.fill(connect,-1);
        int[] visit = new int[n];
        
        // print(connect);
        int[] dp = new int[map.lastKey()];
        
        int ans=0;
        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            HashMap<Integer,Integer> map1 = new HashMap<>();
            for(int src : list) visit[src]=1;
            for(int src : list) {
                // visit[src]=1;
                for(int nbr : graph[src]) {
                    if(visit[nbr]==1) {
                        // System.out.println("start");
                        // print(connect);
                        union(connect,src,nbr);
                        // print(connect);
                    }
                }
                
                
                // int val = find(connect,src);
                // if(map1.containsKey(val)) {
                //     map1.put(val,map1.get(val)+1);
                // } else {
                //     map1.put(val,1);
                // }
                
            }
            for(int src : list) {
                int val = find(connect,src);
                if(map1.containsKey(val)) {
                    map1.put(val,map1.get(val)+1);
                } else {
                    map1.put(val,1);
                }
            }
            // System.out.println(key+" --> "+map1);
            for(int key1 : map1.keySet()) {
                int v1 = nc2(map1.get(key1));
                ans+=v1;
            }
            
        }
        
        
        // System.out.println(map);
        // int ans =n;
        // for(int key : map.keySet()) {
        //     List<Integer> list = map.get(key);
        //     for(int i=0;i<list.size();i++) {
        //         for(int j=i+1;j<list.size();j++) {
        //             if(isValid(graph,list.get(i),list.get(j),new byte[n],key,vals)) {
        //                 ans++;
        //             }
        //         }
        //     }
        // }
        // return ans;
        // System.out.println(nc2(10)+" "+nc2(5));
        return ans+n;
    }
    
    public static void print(int[] a) {
        for(int b : a) System.out.print(b+" ");
        System.out.println();
    }
    
    public static boolean isValid(ArrayList<Integer>[] graph,int src,int dst,byte[] visit,int max,int[] val) {
        if(src==dst) {
            if(max<=val[dst]) return true;
            return false;
        }
        if(max>val[dst]) return false;
        visit[src]=1;
        boolean ans = false;
        for(int nbr : graph[src]) {
            if(visit[nbr]==0) {
                ans |=isValid(graph,nbr,dst,visit,Math.max(max,val[nbr]),val);
            }
            if(ans) break;
        }
        return ans;
    }
}