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
    public int pseudoPalindromicPaths (TreeNode root) {
        return solve(root,new int[10]);
    }
    
    public static int solve(TreeNode root,int[] fre) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) {
            fre[root.val]++;
            if(isPalindrome(fre)) {
                fre[root.val]--;
                return 1;
            }
            fre[root.val]--;
            return 0;
        }
        fre[root.val]++;
        int v1 = solve(root.left,fre);
        int v2 = solve(root.right,fre);
        fre[root.val]--;
        return v1+v2;
    }
    
    public static boolean isPalindrome(int[] a) {
        int odd=0;
        for(int v : a) {
            if(v%2==1) odd++;
        }
        if(odd>1) return false;
        return true;
    }
}
