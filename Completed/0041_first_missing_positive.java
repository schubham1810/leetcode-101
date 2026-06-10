class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i] = n+1;
            }
        }

        for(int i=0;i<n;i++){
            int value = Math.abs(nums[i]);
            if(value>0 && value<=n){
                nums[value-1] = -1 * Math.abs(nums[value-1]);
            }
        }

        int i;
        for(i=0;i<n;i++){
            if(nums[i]>0) return i+1;
        }
        return i+1;
    }
}