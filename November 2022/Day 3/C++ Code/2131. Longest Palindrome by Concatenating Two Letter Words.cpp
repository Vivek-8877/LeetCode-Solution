// Problem Link :-
// Video Solution Link :- 

class Solution {
public:
    // Time Complexity :- O(n.log(n));
    // Space Complexity :- O(n);
    int longestPalindrome(vector<string>& words) {
        map<string,int> mp;
        for(string word : words) {
            mp[word]++;
        }
        
        int ans=0;
        int ct=0;
        for(string word : words) {
            if(mp[word]<=0) continue;
            
            string word1;
            word1+=word[1];
            word1+=word[0];
            int fre = mp[word1];
            mp[word]--;
            
            if(word[0]==word[1]) {
                if(fre>1) {
                    ans+=4;
                    mp[word1]--;
                } else if(fre==1) {
                    ct++;
                }
            } else {
                if(fre!=0) {
                    ans+=4;
                    mp[word1]--;
                }
            }
        }
        if(ct>0) ans+=2;
        return ans;
    }
};
