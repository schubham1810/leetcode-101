class Solution {
    public int missingNumber(int[] nums) {
        long sum = 0;
        for(int i=0;i<nums.length;i++) {
        	sum+=nums[i];
        }
        
        long exSum = (nums.length * (nums.length+1))/2;
        
        return (int) (exSum-sum);
    }
}