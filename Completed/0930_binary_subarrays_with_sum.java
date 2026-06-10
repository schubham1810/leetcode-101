class Solution {
    private int rubbish(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0;
        int count = 0;
        int sum=0;
        for(int r = 0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            if(sum<=goal){
                count+= (r-l+1);
            }
        }
        System.gc();
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return rubbish(nums,goal) - rubbish(nums,goal-1);
    }
}