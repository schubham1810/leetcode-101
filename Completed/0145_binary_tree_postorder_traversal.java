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
//////////////////////// Recursion /////////////////////////
// class Solution {
//     private void postOrder(List<Integer> arr, TreeNode node){
//         if(node==null) return;
//         postOrder(arr,node.left);
//         postOrder(arr,node.right);
//         arr.add(node.val);
//     }
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> arr = new ArrayList<>();
//         postOrder(arr,root);
//         return arr;   
//     }
// }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        if(root==null) return arr;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left!=null){
                st1.push(root.left);
            }
            if(root.right!=null){
                st1.push(root.right);
            }
        }

        while(!st2.isEmpty()){
            TreeNode node = st2.pop();
            arr.add(node.val);
        }        
        return arr;   
    }
}