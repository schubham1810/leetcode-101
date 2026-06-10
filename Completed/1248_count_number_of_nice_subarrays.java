class Solution {
    private int rubbish(int[] arr, int k){
        int l =0;
        int count = 0;
        int oddCount = 0;
        for(int r=0;r<arr.length;r++){
            if((arr[r]&1) ==1){
                oddCount+=1;
            }
            while(oddCount>k){
                if((arr[l]&1) ==1){
                    oddCount-=1;
                }
                l++;
            }
            if(oddCount<=k){
                count+= (r-l+1);
            }
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return rubbish(nums,k) - rubbish(nums,k-1);
    }
}