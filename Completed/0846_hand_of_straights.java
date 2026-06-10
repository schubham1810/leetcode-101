class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        if(hand.length % groupSize !=0) return false;
        for(int i: hand){
            pq.add(i);
        }

        while(!pq.isEmpty()){
            int x = pq.peek();
            for(int i=0;i<groupSize;i++){
                if(!pq.remove(x+i)) return false;
            }
        }
        return true;
    }
}