class Solution {

    private boolean check(int i,int j, int index, String word, char[][] mat,int[][] visited){
        if(index==word.length()) return true;

        if(i<0 || j<0 || j+1>mat[0].length || i+1> mat.length || visited[i][j]==1) return false;

        if(mat[i][j]!= word.charAt(index)) return false;
        visited[i][j] = 1;
        if(check(i-1,j,index+1,word,mat,visited)||
            check(i,j-1,index+1,word,mat,visited)||
            check(i+1,j,index+1,word,mat,visited)||
            check(i,j+1,index+1,word,mat,visited)){
            return true;
        }
        visited[i][j] = 0;
        return false;
        // System.out.println(word.charAt(index));
        // boolean flagr = false, flagl = false, flagt = false,flagb = false;
        //bottom
        // if(i+1<mat.length && mat[i+1][j] == word.charAt(index) && visited[i+1][j]==0){
        //     visited[i+1][j]=1;
        //     flagb = check(i+1,j, index+1, word, mat,visited);
        //     if(!flagb) visited[i+1][j]=0;
        // }

        // //left
        // if(j>0 && mat[i][j-1] == word.charAt(index) && visited[i][j-1]==0){
        //     visited[i][j-1]=1;
        //     flagl =  check(i,j-1, index+1, word, mat,visited);
        //     if(!flagl) visited[i][j-1]=0;
        // }

        // //top
        // if(i>0 && mat[i-1][j] == word.charAt(index) && visited[i-1][j]==0){
        //     visited[i-1][j]=1;
        //     flagt =  check(i-1,j, index+1, word, mat,visited);
        //     if(!flagt) visited[i-1][j]=0;
        // }

        // //right
        // if(j+1<mat[0].length && mat[i][j+1]== word.charAt(index) && visited[i][j+1]==0){
        //     visited[i][j+1]=1;
        //     flagr =  check(i,j+1, index+1, word, mat,visited);
        //     if(!flagr) visited[i][j+1]=0;
        // }

        // return flagt || flagb || flagr || flagl;

    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    int[][] visited = new int[board.length][board[0].length];
                    // visited[i][]=1;
                    if(check(i,j,0,word,board,visited)) return true;
                }
            }
        }
        return false;
    }
}