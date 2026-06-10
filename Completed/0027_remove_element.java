class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if(nums[l]==val){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r--;
            }else l++;
            
        }
        return r+1;
    }
}