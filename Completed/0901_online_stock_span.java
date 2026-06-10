class StockSpanner {

    Stack<Pair<Integer,Integer>> st;
    int ind ;
    public StockSpanner() {
        st = new Stack<>();
        ind = -1;
    }
    
    private int ple(int k){
        ind++;
        while(!st.isEmpty() && st.peek().getKey()<= k){
            st.pop();
        }
        int ans = ind - (st.isEmpty()? -1: st.peek().getValue());
        Pair p1 = new Pair(k, ind);
        st.push(p1);

        return ans;
    }
    public int next(int price) {
        return ple(price);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */