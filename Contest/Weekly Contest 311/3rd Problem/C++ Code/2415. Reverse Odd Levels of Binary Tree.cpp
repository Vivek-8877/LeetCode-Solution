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
    TreeNode* reverseOddLevels(TreeNode* root) {
        queue<TreeNode*> dq;
        dq.push(root);
        int lvl=0;
        while(dq.size()>0) {
            int s = dq.size();
            if(lvl%2==1) {
                
                vector<TreeNode*> list;
                vector<int> list1;
                
                for(int i=0;i<s;i++) {
                    TreeNode* p = dq.front();
                    dq.pop();
                    if(p->left!=NULL) dq.push(p->left);
                    if(p->right!=NULL) dq.push(p->right);
                    list.push_back(p);
                    list1.push_back(p->val);
                }
                
                for(int i=0,j=s-1;i<s;i++,j--) {
                    list[i]->val=list1[j];
                }
                
            } else {
                
                for(int i=0;i<s;i++) {
                    TreeNode* p = dq.front();
                    dq.pop();
                    if(p->left!=NULL) dq.push(p->left);
                    if(p->right!=NULL) dq.push(p->right);
                }
                
            }
            lvl++;
        }
        return root;
    }
};
