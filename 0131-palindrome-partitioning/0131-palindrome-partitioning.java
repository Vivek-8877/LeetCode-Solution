class Solution {
    public static boolean isPalindrom(String s) {
        for(int i=0,j=s.length()-1;i<j;i++,j--) {
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>[] list = new ArrayList[s.length()];
        List<String>[] a = new ArrayList[s.length()];
        for(int i=0;i<s.length();i++) {
            a[i]=new ArrayList<>();
            for(int j=i+1;j<=s.length();j++) {
                if(isPalindrom(s.substring(i,j))) {
                    a[i].add(s.substring(i,j));
                }
            }
            // System.out.println(a[i]);
        }
        for(int i=s.length()-1;i>=0;i--) {
            list[i]=new ArrayList<>();
            List<List<String>> bb = new ArrayList<>();
            for(int j=0;j<a[i].size();j++) {
                int idx = i+a[i].get(j).length();
                // List<List<String>> bb = new ArrayList<>();
                if(idx<s.length()) {
                    for(List<String> str : list[idx]) {
                        List<String> fa = new ArrayList<>();
                        fa.add(a[i].get(j));
                        for(String ss : str) {
                            fa.add(ss);
                        }
                        bb.add(fa);
                    }
                } else {
                    List<String> ans = new ArrayList<>();
                    ans.add(a[i].get(j));
                    bb.add(ans);
                }
                // System.out.println(bb);
                // list[i] = bb;
            }
            list[i]=bb;
        }
        return list[0];
    }
}