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
class Pair{
    TreeNode node;
    int index;
    // Constructor for pair.
    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root,0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            int first= 0;
            int last = 0;
            for(int i=0;i<size;i++){
                Pair temp = q.poll();
                if(i==0) first = temp.index;
                if(i==size-1) last = temp.index;

                if(temp.node.left!=null) q.add(new Pair(temp.node.left,(2*(temp.index-min)+1)));
                if(temp.node.right!=null) q.add(new Pair(temp.node.right,(2*(temp.index-min)+2)));
            }
            maxWidth = Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}