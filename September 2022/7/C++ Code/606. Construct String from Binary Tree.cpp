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
    string tree2str(TreeNode* root) {
        if(root==NULL) return "";
        
        string lft = tree2str(root->left);
        string rt = tree2str(root->right);
        
        
        if(lft.length()==0 && rt.length()==0) {
            
        } else if(lft.length()==0) {
            lft="("+lft+")";
            rt="("+rt+")";
        } else if(rt.length()==0) {
            lft="("+lft+")";
        } else {
            lft="("+lft+")";
            rt="("+rt+")";
        }
        return to_string(root->val)+lft+rt;
    }
};
