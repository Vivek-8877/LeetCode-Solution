// Problem Link :- https://leetcode.com/problems/where-will-the-ball-fall/
// Video Solution Link :- https://www.youtube.com/watch?v=myc1tNf1ZBU

class Solution {
public:
    int dfs(vector<vector<int>>& grid,int i,int j) {
        if(i>=grid.size()) return j;
        
        if(i<0 || j<0 || j>=grid[i].size()) {
            return -1;
        }
        
        if(grid[i][j]==1) {
            if(j+1<grid[i].size() && grid[i][j+1]==1) {
                return dfs(grid,i+1,j+1);
            } else {
                return -1;
            }
        } else {
            if(j-1>=0 && grid[i][j-1]==-1) {
                return dfs(grid,i+1,j-1);
            } else {
                return -1;
            }
        }
        
    }
    
    vector<int> findBall(vector<vector<int>>& grid) {
        vector<int> ans;
        for(int i=0;i<grid[0].size();i++) {
            ans.push_back(dfs(grid,0,i));
        }
        return ans;
    }
};
