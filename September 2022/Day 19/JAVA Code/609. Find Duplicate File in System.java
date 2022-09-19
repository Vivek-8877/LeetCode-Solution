class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] str = path.split("[ ,.)(]+");
            for(int i=1;i<str.length;i+=3) {
                if(map.containsKey(str[i+2])) {
                    List<String> list = map.get(str[i+2]);
                    list.add(str[0]+"/"+str[i]+".txt");
                    map.put(str[i+2],list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str[0]+"/"+str[i]+".txt");
                    map.put(str[i+2],list);
                }
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key).size()>1) ans.add(map.get(key));
        }
        return ans;
    }
}
