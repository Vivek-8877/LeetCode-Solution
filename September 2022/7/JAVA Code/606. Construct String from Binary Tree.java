/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        
        String lft = tree2str(root.left);
        String rt = tree2str(root.right);
        
        
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
        return root.val+lft+rt;
    }
}
