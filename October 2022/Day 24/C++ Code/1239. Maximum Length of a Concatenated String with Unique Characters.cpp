// T.C :- O(2^n)

class Solution {
public:
    int maxLength(vector<string>& arr) {
        vector<int> fre(26,0);
        return f(arr,0,fre);
    }
    
    int f(vector<string>& arr,int idx,vector<int>& fre) {
        if(idx>=arr.size()) {
            return 0;
        }
        int ans =0;
        bool isValid = true;
        
        for(int i=0;i<arr[idx].length();i++) {
            int ix = arr[idx][i]-'a';
            if(fre[ix]>0) {
                isValid=false;
            }
            fre[ix]++;
        }
        
        if(isValid) {
            int a1 = f(arr,idx+1,fre)+arr[idx].length();
            ans = max(ans,a1);
        }
        
        for(int i=0;i<arr[idx].length();i++) {
            int ix = arr[idx][i]-'a';
            fre[ix]--;
        }
        
        int a2 = f(arr,idx+1,fre);
        ans = max(ans,a2);
        return ans;
        
    }
    
};
