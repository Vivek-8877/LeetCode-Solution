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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null) return null;
        
        boolean left = isOne(root.left);
        boolean right = isOne(root.right);
        
        
        if(left && right) {
            root.left=pruneTree(root.left);
            root.right=pruneTree(root.right);
        } else if(left) {
            root.right=null;
            root.left=pruneTree(root.left);
        } else if(right) {
            root.left=null;
            root.right=pruneTree(root.right);
        } else {
            root.left=null;
            root.right=null;
        }
        
        if(root.left==null && root.right==null && root.val==0) root=null;
        
        return root;
    }
    
    public static boolean isOne(TreeNode root) {
        if(root==null) return false;
        if(root.val==1) return true;
        return isOne(root.left) | isOne(root.right);
    }
}
