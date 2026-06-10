class Solution {
    public int maxScore(int[] arr, int k) {
        int r = 0;
        int l = 0;
        int maxSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<k;i++){
            leftSum+=arr[i];
        } 
        maxSum = leftSum;
        r= arr.length-1;
        for(int i=k-1;i>=0;i--){
            leftSum-= arr[i];
            rightSum+= arr[r];
            r--;
            maxSum = Math.max(maxSum,(leftSum+rightSum));
        }
        return maxSum;       
    }
}