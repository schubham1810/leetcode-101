class Solution {
    public int bs(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid= (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int i = bs(nums,target);
        int j=i;
        if(i!=-1){
            while(i+1!= nums.length && nums[i]==nums[i+1]){
                i++;
            }
            while(j-1!= -1 && nums[j]==nums[j-1]){
                j--;
            }
        }else{
            j=-1;
        }
        int[] arr = {j,i};
        return arr;
    }
}