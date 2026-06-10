class Solution {
    public int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
    public int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low= 1;
        int high = findMax(piles);
        int ans=0;
        while(low<=high){
            int mid = (low+high)/2;
            int hours = calculateTotalHours(piles,mid);
            if(hours > h){
                low = mid+1;
            }else{
                ans = mid;
                high = mid -1;
            }
        }
        return ans;
    }
}