 class Tuple{
    TreeNode node;
    int row;
    int col;
    // Constructor for tuple.
    public Tuple(TreeNode _node, int _row, int _col){
        node = _node;
        row = _row;
        col = _col;
    }
 }
class Solution {


    public List<List<Integer>> verticalTraversal(TreeNode root) {


        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();


        Queue<Tuple> q = new LinkedList<Tuple>();

        // Insert the tuple
        q.add(new Tuple(root,0,0));

        while(!q.isEmpty()){

            Tuple tuple = q.poll();

            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x)) map.put(x,new TreeMap<>());

            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());

            map.get(x).get(y).add(node.val);

            if(node.left!=null) q.add(new Tuple(node.left,x-1,y+1));
            if(node.right!=null) q.add(new Tuple(node.right, x+1,y+1));
        }

        List<List<Integer>> list = new ArrayList<>();

  
        for(TreeMap<Integer,PriorityQueue<Integer>> yn : map.values()){
            list.add(new ArrayList<>());

            for(PriorityQueue<Integer> nodes : yn.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}