class Solution {
    public int splits(int[] arr, int sum){
        int count = 1;
        int currSum = 0;
        for(int i=0;i<arr.length;i++){
            if(currSum+arr[i]<=sum){
                currSum+= arr[i];
            }else{
                currSum = arr[i];
                count+=1;
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<nums.length;i++){
            if(low<nums[i]){
                low = nums[i];
            }
            high += nums[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            int s = splits(nums,mid);
            if(s>k){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return low;
    }
}