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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode temp = root;
        boolean ins = false;
        while(!ins){
            if(val>temp.val){
                if(temp.right==null){
                    TreeNode res = new TreeNode(val);
                    temp.right = res;
                    ins = true;
                    continue;
                }
                temp = temp.right;
            }else{
                if(temp.left==null){
                    TreeNode res = new TreeNode(val);
                    temp.left = res;
                    ins = true;
                    continue;
                }
                temp = temp.left;
            }
        }
        return root;
    }
}