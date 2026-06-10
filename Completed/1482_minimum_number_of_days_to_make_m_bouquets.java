class Solution {

    public boolean possible(int[] arr, int m, int k, int day){
        int count=0;
        int bouquetCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                count++;
            }else{
                bouquetCount += (count/k);
                count = 0;
            }
        }
        bouquetCount += (count/k);
        if(bouquetCount<m){
            return false;
        }else{
            return true;
        }
    }

    public int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public int findMin(int[] v) {
        int mini = Integer.MAX_VALUE;;
        int n = v.length;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, v[i]);
        }
        return mini;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length< ((double)m*(double)k)){
            return -1;
        }
        int low = findMin(bloomDay);
        int high = findMax(bloomDay);
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay,m,k,mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}