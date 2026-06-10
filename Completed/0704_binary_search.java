class Solution {
    public int bs(int[] nums,int target,int low,int high){
        if(low>high) return -1;

        int mid = (low+high)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid]<target) return bs(nums,target,mid+1,high);
        else return bs(nums,target,low,mid -1);
    }
    public int search(int[] nums, int target) {
        // int low = 0;
        // int high = nums.length-1;
        // while(low<=high){
        //     int mid = (low+high)/2;
        //     if(nums[mid] == target) return mid;
        //     else if(nums[mid]<target) low = mid+1;
        //     else high = mid-1; 
        // }
        return bs(nums,target,0,nums.length-1);
    }
}