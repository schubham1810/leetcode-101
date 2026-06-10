class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] arr = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.getFirst()<=(i-k)){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                arr[i+1-k] = nums[dq.getFirst()];
            }
        }
        return arr;
    }
}