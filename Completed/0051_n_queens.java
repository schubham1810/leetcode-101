class Solution {

    private List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private void generateCombinations(int col, char[][] board,List<List<String>> result, int[] rowCheck, int[] downDiagonal, int[] upDiagonal){
        int n = board.length;
        if(col==n){
            result.add(construct(board));
            return;
        }
        for(int row=0; row<n;row++){
            if(rowCheck[row]==0 && downDiagonal[row+col]==0 && upDiagonal[n-1+ col-row]==0){
                board[row][col]='Q';
                rowCheck[row]=1;
                downDiagonal[row+col]=1;
                upDiagonal[n-1+ col-row] =1;
                generateCombinations(col+1,board,result,rowCheck,downDiagonal,upDiagonal);
                board[row][col]='.';
                rowCheck[row]=0;
                downDiagonal[row+col]=0;
                upDiagonal[n-1+ col-row] =0;
            }            
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        generateCombinations(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }
}