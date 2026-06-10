class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int row=1;row<=numRows;row++){
            List<Integer> arr = new ArrayList<>();
            int ans = 1;
            arr.add(ans);
            for(int col=1;col<row;col++){
                ans = ans*(row-col);
                ans = ans/col;
                arr.add(ans);
            }
            result.add(arr);
        }
        return result;
    }
}