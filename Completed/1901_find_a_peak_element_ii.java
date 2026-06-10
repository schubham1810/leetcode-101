class Solution {

    public int findMaxIndex(int[][] arr, int j){
        int index = 0;
        int max = arr[0][j];
        for(int i=0;i<arr.length;i++){
            if(arr[i][j]>max){
                max = arr[i][j];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length;
        while(low<=high){
            int mid = (low+high)/2;
            int max = findMaxIndex(mat, mid);
            int left = mid-1>=0 ? mat[max][mid-1] : -1;
            int right = mid+1<mat[0].length ? mat[max][mid+1] : -1;
            if(mat[max][mid]>left && mat[max][mid]>right){
                int[] arr = {max,mid};
                return arr;
            }else if(mat[max][mid]<left) high = mid -1;
            else low = mid + 1;
        }
        int[] arr = {-1,-1};
        return arr;
    }
}