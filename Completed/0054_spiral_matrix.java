class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        boolean entry = false;
        while(top<=bottom && left<=right){            
            for(int i= left;i<=right;i++){
                entry = true;
                result.add(matrix[top][i]);
            }
            if(entry){
                entry = false;
                for(int i=top+1;i<=bottom;i++){
                    entry= true;
                    result.add(matrix[i][right]);
                }
            }
            if(entry){
                entry = false;
                for(int i=right-1;i>=left;i--){
                    entry = true;
                    result.add(matrix[bottom][i]);
                }
            }
            if(entry){
                entry = false;
                for(int i=bottom-1;i>top;i--){
                    result.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;

        } 
        return result;
    }
}