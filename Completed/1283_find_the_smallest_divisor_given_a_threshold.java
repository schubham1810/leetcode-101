class Solution {

    public boolean possible(int[] arr, int thr, int mid){
        int total = 0;
        for(int i=0;i<arr.length;i++){
            total += Math.ceil((double)arr[i]/(double)mid);
            if(total>thr){
                return false;
            }
        }        
        return true;
    }

    public int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = findMax(nums);

        while(low<=high){
            int mid = (low+high)/2;
            if(possible(nums,threshold,mid)){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return low;
    }
}