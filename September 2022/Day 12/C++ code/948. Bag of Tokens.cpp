class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        sort(tokens.begin(),tokens.end());
        int lft=0,rt=tokens.size()-1;
        int ans=0,score=0;
        while(lft<=rt) {
            if(power<tokens[lft]) {
                if(score>0) {
                    power+=tokens[rt];
                    score--;
                    rt--;
                } else {
                    break;
                }
            } else {
                power-=tokens[lft];
                score++;
                lft++;
            }
            ans = max(ans,score);
        }
        return ans;
    }
};
