class Solution {
public:
    
    // Time Complexity :- O(n^4);
    
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        int ans=0;
        for(int i=0;i<img1.size();i++) {
            for(int j=0;j<img1.size();j++) {
                ans = max(ans,rightDownLeftUp(img1,img2,i,j));
                ans = max(ans,rightDownLeftUp(img2,img1,i,j));
                
                ans = max(ans,rightUpLeftDown(img1,img2,i,j));
                ans = max(ans,rightUpLeftDown(img2,img1,i,j));
            }
        }
        return ans;
    }
    
    // Total Common One
    
    int rightDownLeftUp(vector<vector<int>>& a,vector<vector<int>>& b,int iShift,int jShift) {
        int count=0;
        for(int i=iShift;i<a.size();i++) {
            for(int j=jShift;j<a.size();j++) {
                if(a[i][j]==1 && b[i-iShift][j-jShift]==1) count++;
            }
        }
        return count;
    }
    
    int rightUpLeftDown(vector<vector<int>>& a,vector<vector<int>>& b,int iShift,int jShift) {
        int count=0;
        for(int i=iShift;i<a.size();i++) {
            for(int j=0;j<a.size()-jShift;j++) {
                if(a[i][j]==1 && b[i-iShift][j+jShift]==1) count++;
            }
        }
        return count;
    }
    
};
