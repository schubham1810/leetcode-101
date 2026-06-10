class Solution {
    public int noOfDays(int[] arr, int cap){
        int days = 1;
        int load = 0;
        for(int i=0;i<arr.length;i++){
            if(load+arr[i]>cap){
                days+=1;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>low){
                low = weights[i];
            }
            high += weights[i];
        }
        while(low<=high){
            int mid = (low+high)/2;

            int d = noOfDays(weights,mid);
            if(d<=days){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}