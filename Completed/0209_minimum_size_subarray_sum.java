class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int r=1;
        if(nums[l]>target) return 1;
        if(nums.length<=1) return 0;
        int sum = nums[l]+nums[r];
        int min = Integer.MAX_VALUE;
        while(r<nums.length){
            if(sum>=target){
                min = Math.min(min,r-l+1);
            }

            if(sum<=target){
                r++;
                if(r==nums.length) break;
                sum+=nums[r];
            }else{
                sum-=nums[l];
                l++;
            }
        }
        return min==Integer.MAX_VALUE?0:min ;
    }
}