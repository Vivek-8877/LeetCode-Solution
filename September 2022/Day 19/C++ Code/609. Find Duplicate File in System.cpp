class Solution {
public:
    vector<vector<string>> findDuplicate(vector<string>& paths) {
        map<string,vector<string>> map;
        for(string path : paths) {
            vector<string> str = split(path);
            for(int i=1;i<str.size();i+=3) {
                if(map.find(str[i+2])==map.end()) {
                    vector<string> list;
                    list.push_back(str[0]+"/"+str[i]+".txt");
                    map.insert({str[i+2],list});
                } else {
                    map[str[i+2]].push_back(str[0]+"/"+str[i]+".txt");
                }
            }
        }
        
        vector<vector<string>> ans;
        for(auto key : map) {
            if(key.second.size()>1) ans.push_back(key.second);
        }
        return ans;
    }
    
    vector<string> split(string s) {
        vector<string> list;
        string str = "";
        for(int i=0;i<s.length();i++) {
            if(s[i]=='.' || s[i]==' ' || s[i]=='(' || s[i]==')' || s[i]==',') {
                if(str.length()!=0) list.push_back(str);
                str="";
            } else {
                str+=s[i];
            }
        }
        if(str.length()!=0) list.push_back(str);
        return list;
    }
};
