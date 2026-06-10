class Solution {
    public boolean canJump(int[] nums) {
        int min = 0;
        int max = 0;
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
        for(int i=0;i<nums.length-1;i++){
            min= nums[i]==0? i: i+1;
            max = Math.max(max,i+nums[i]);
            if(max>=nums.length-1) return true;
            if(i==min && i==max) return false;
        }
        return false;
    }
}