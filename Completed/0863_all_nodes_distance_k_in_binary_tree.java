/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, Map<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(node.left!=null){
                    parentMap.put(node.left,node);
                    q.add(node.left);
                }
                if(node.right!=null){
                    parentMap.put(node.right,node);
                    q.add(node.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        markParents(root,parentMap);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int curr = 0;
        while(!q.isEmpty()){
            if(curr==k) break;            
            curr++;
            int size = q.size();
            for(int i=0;i<size;i++){
            	TreeNode node = q.poll();
                if(node.left!=null && visited.get(node.left)==null){
                    visited.put(node.left,true);
                    q.add(node.left);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    visited.put(node.right,true);
                    q.add(node.right);
                }
                if(parentMap.get(node)!=null && visited.get(parentMap.get(node))==null){
                    visited.put(parentMap.get(node),true);
                    q.add(parentMap.get(node));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            result.add(temp.val);
        }
        return result;
    }
}