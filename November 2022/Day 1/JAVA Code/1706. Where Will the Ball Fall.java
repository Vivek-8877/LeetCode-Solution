// Problem Link :- https://leetcode.com/problems/where-will-the-ball-fall/
// Video Solution Link :- https://www.youtube.com/watch?v=myc1tNf1ZBU


class Solution {
    public static int dfs(int[][] grid,int i,int j) {
        if(i>=grid.length) return j;
        
        if(i<0 || j<0 || j>=grid[i].length) {
            return -1;
        }
        
        if(grid[i][j]==1) {
            if(j+1<grid[i].length && grid[i][j+1]==1) {
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
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for(int i=0;i<ans.length;i++) {
            ans[i]=dfs(grid,0,i);
        }
        return ans;
    }
}
