class Solution {
    public boolean check(int[] nums) {
        boolean errorCheck = false;
        for(int i=0;i<nums.length;i++){
            int j=(i+1)%nums.length;
            if(nums[j]<nums[i] && !errorCheck){
                errorCheck = true;
            }else if(nums[j]<nums[i] && errorCheck){
                return false;
            }
        }
        return true;
    }
}