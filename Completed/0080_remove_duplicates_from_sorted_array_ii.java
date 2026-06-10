class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int curr = 0;
        int s=0;

        while(l<=r){
            curr=0;
            int n = nums[l];
            while(l<=r && nums[l]==n && curr<2){
                curr++;
                nums[s]=nums[l];
                l++;
                s++;
            }            
            while(l<=r && nums[l]==n){
                l++;
            }
            
        }
        return s;
    }
}