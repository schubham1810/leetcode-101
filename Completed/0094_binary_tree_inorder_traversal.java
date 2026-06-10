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
////////////////////////////// Recursion //////////////////////////
// class Solution {
//     private void inOrder(List<Integer> arr, TreeNode node){
//         if(node==null) return;
//         inOrder(arr,node.left);
//         arr.add(node.val);
//         inOrder(arr,node.right);
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> arr = new ArrayList<>();
//         inOrder(arr,root);
//         return arr;   
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        if(root==null) return arr;

        TreeNode node = root;
        while(true){
            if(node!=null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()) break;
                node = st.pop();
                arr.add(node.val);
                node = node.right;
            }            
        }  
        return arr;
    }
}
