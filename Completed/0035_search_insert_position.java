class Solution {
    public int searchInsert(int[] nums, int target) {
         int low=0;
        int high=nums.length-1;
        int index=-1;
        while(low<=high){
            int mid= (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                index=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return index+1;
    }
}