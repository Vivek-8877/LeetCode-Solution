class Solution {
    
    // Time Complexity :- O(n.m.log(n));
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        String[][] s1 = new String[n][2];
        for(int i=0;i<n;i++) {
            s1[i][0]= sort(strs[i]);
            s1[i][1]=Integer.toString(i);
        }
        
        Arrays.sort(s1,(a,b) -> compare(a[0],b[0]));
        
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int idx = Integer.parseInt(s1[i][1]);
            list.add(strs[idx]);
            if(i!=n-1 && compare(s1[i][0],s1[i+1][0])!=0) {
                ans.add(list);
                list = new ArrayList<>();
            }
        }
        ans.add(list);
        return ans;
    }
    
    // Time Compleixty :- O(m)
    public static int compare(String s1,String s2) {
        return s1.compareTo(s2);
    }
    
    // Time Complexity :- O(m.log(m))
    public static String sort(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
