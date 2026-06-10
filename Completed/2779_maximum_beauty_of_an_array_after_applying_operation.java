class Solution {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        int count = Integer.MIN_VALUE;

        for(int r=0;r<nums.length;r++){
            while(nums[r]- nums[l] > 2*k){
                l++;
            }
            count = Math.max(count,r-l+1);
        }
        return count;
    }
}