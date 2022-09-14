/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    int pseudoPalindromicPaths (TreeNode* root) {
        vector<int> fre(10,0);
        return solve(root,fre);
    }
    
    int solve(TreeNode* root,vector<int>& fre) {
        if(root==NULL) return 0;
        
        if(root->left==NULL && root-> right==NULL) {
            fre[root->val]++;
            bool isValid = isPalindrome(fre);
            fre[root->val]--;
            if(isValid) return 1;
            return 0;
        }
        
        fre[root->val]++;
        int lft = solve(root->left,fre);
        int rt = solve(root->right,fre);
        fre[root->val]--;
        return lft+rt;
    }
    
    bool isPalindrome(vector<int>& a) {
        int odd=0;
        for(int i=0;i<a.size();i++) {
            if(a[i]%2==1) odd++;
        }
        if(odd>1) return false;
        return true;
    }
    
};
