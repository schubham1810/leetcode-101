class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();

        for(int i = 0;i<nums.length;i++){
            if(pQ.size() <k){
                pQ.add(nums[i]);
            }else{
                if(pQ.peek()<nums[i]){
                    pQ.poll();
                    pQ.add(nums[i]);
                }
            }
        }


        return pQ.peek();
    }
}