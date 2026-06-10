class Solution {

    public void reverseArraySection(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements at start and end
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            // Move the pointers towards each other
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int index = -1;
    	for(int i=nums.length-2;i>=0;i--) {
    		if(nums[i]<nums[i+1]) {
    			index = i;
    			break;
    		}
    	}
    	
    	if(index==-1) {
    		reverseArraySection(nums, 0, nums.length-1);
    		return;
    	}
    	
    	for(int i=nums.length-1;i>=0;i--) {
    		if(nums[i]>nums[index]) {
    			int temp = nums[i];
    			nums[i] = nums[index];
    			nums[index] = temp;
    			break;
    		}
    	}
    	
    	reverseArraySection(nums, index+1, nums.length-1);
    }
}