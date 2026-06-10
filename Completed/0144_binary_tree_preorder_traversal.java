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

/////////////////////////////////////  Recursion  ///////////////////////////////////////
// class Solution {
//     private void preOrder(List<Integer> arr, TreeNode node){
//         if(node==null) return;
//         arr.add(node.val);
//         preOrder(arr,node.left);
//         preOrder(arr,node.right);
//     }
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> arr = new ArrayList<>();
//         preOrder(arr,root);
//         return arr;   
//     }
// }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        if(root==null) return arr;

        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            arr.add(node.val);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
        return arr;   
    }
}