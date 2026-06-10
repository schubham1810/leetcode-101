class Node{
    int val;
    int key;
    Node prev;
    Node next;

    Node(int x, int y){
        key = x;
        val = y;
        prev = null;
        next = null;
    }
}    
class LRUCache {
    private int cap;
    Node head = new Node(-1, -1), tail = new Node(-1, -1);
    private HashMap<Integer,Node> hm = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;    
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            deleteNode(node);
            insertNode(node);
            return node.val;
        }else return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            deleteNode(node);
            insertNode(node);
        }else{
            if(hm.size()== cap){
                Node node = tail.prev;
                deleteNode(node);
            }
            Node newNode = new Node(key,value);
            insertNode(newNode);
            
        }
        
    }

    public void deleteNode(Node node){
        hm.remove(node.key);
        Node tempPrev = node.prev;
        Node tempNext = node.next;
        tempNext.prev = tempPrev;
        tempPrev.next = tempNext;
    }

    public void insertNode(Node node){
        hm.put(node.key,node);
        Node tempNext = head.next;
        head.next = node;
        node.next = tempNext;
        tempNext.prev= node;
        node.prev = head;
        // System.out.println(tail.prev.val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */