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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int n = q.size();
            Integer[] temp = new Integer[n];
            for(int i=0;i<n;i++){
                TreeNode node = q.remove();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                if(flag){
                    temp[i]=(node.val);
                }else{
                    temp[n-1-i]=node.val;
                }
            }
            flag = !flag;
            ans.add(Arrays.asList(temp));
        }
        return ans;
    }
}