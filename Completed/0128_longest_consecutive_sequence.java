class Solution {
    void quickSort(int nums[], int low, int high) {
        // code here
        if(low<high){
            int partitionIndex = partition(nums,low,high);
            quickSort(nums,low,partitionIndex -1);
            quickSort(nums,partitionIndex +1, high);
        }
    }

    int partition(int nums[], int low, int high) {
        // your code here
        int pivot = low;
        int i=low;
        int j=high;
        
        while(i<j){
            while(nums[i]<=nums[pivot]  && i<=high-1){
                i++;
            }
            while(nums[j]>nums[pivot] && j>=low+1){
                j--;
            }
            if(i<j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
		int maxLen = 0;
		int len = 0;
		
		for(int element: nums) {
			set.add(element);
		}
		
		for(Integer i: set){
            len = 1;
            if(!set.contains(i-1)){
                int j = i;
                while(set.contains(j+1)){
                    j++;
                    len++;
                }
            }
            maxLen = Math.max(maxLen,len);
        }
		return maxLen;
    }
}