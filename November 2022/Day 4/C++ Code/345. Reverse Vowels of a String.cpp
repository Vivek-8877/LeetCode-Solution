// Problem Link :- https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// Video Solution Link :- https://www.youtube.com/watch?v=z5zMFLNvjw0

class Solution {
public:
    string reverseVowels(string s) {
        vector<char> vowels{'a','e','i','o','u','A','E','I','O','U'};
        vector<char> list_of_vowels;
        for(int i=0;i<s.length();i++) {
            for(char vowel : vowels) {
                if(vowel==s[i]) {
                    list_of_vowels.push_back(vowel);
                    break;
                }
            }
        }
        string ans="";
        int idx = list_of_vowels.size()-1;
        for(int i=0;i<s.length();i++) {
            char c = s[i];
            for(char vowel : vowels) {
                if(vowel==s[i]) {
                    c=list_of_vowels[idx];
                    idx--;
                    break;
                }
            }
            ans+=c;
        }
        return ans;
    }
};
