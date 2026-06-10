class Solution {
    // public boolean findValue(int[] arr, int target){
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(low<=high){
    //         int mid = (low+high)/2;
    //         if(arr[mid] == target){
    //             return true;
    //         }else if(arr[mid]>target){
    //             high = mid -1;
    //         }else{
    //             low = mid + 1;
    //         }
    //     }
    //     return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m-1;
        while(row<n && col>=0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}