class Solution {
public:
    bool arrayStringsAreEqual(vector<string>& word1, vector<string>& word2) {
        int i=0,j=0;
        for(string word : word1) {
            for(int idx=0;idx<word.length();idx++) {
                if(i>=word2.size() || word2[i][j]!=word[idx]) return false;
                j++;
                if(j>=word2[i].length()) {
                    i++;
                    j=0;
                }
            }
        }
        if(i<word2.size() || j!=0) return false;
        return true;
    }
};
