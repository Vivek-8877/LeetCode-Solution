class Solution {
    // T.C => o(n);
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int lft=0,rt=tokens.length-1;
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
            ans = Math.max(ans,score);
        }
        return ans;
    }
}
