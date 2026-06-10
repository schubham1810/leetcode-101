class Solution {

    private boolean isSafe(int ind,int jnd, char[][] board, char c){
        for(int i=0;i<9;i++){
            if(board[ind][i]==c) return false;
            if(board[i][jnd]==c) return false;
            if (board[3 * (ind / 3) + i / 3][3 * (jnd / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public boolean solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') continue;

                for(char c = '1';c <= '9'; c++){
                    if(isSafe(i,j,board,c)){
                        board[i][j]=c;
                        if(solveSudoku(board)) return true;
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }
}