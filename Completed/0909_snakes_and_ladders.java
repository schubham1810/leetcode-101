class Solution {
    
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private Pair getCoordinates(int curr,int n){
        int x = n - (curr-1)/n-1;
        int y = (curr-1)%n;
        if(n%2==x%2){
            y=n-y-1;
        }
        return new Pair(x,y);
    }
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> q = new LinkedList<>();
        int n = board.length;
        boolean[][] visited = new boolean[n][n]; 
        q.add(1);
        int maxSteps = 0;
        visited[n-1][0] = true;
        while(!q.isEmpty()){
        	int size = q.size();
        	while(size-->0) {
        		int top = q.poll();
        		if(top==(n*n)){
        			return maxSteps;
        		}
        		for(int i=1;i<=6;i++){
        			int curr = top+i;
        			if(curr>(n*n)) {
        				continue;
        			}
        			Pair temp = getCoordinates(curr,n);
        			int x = temp.x;
        			int y = temp.y;
        			
        			if(visited[x][y]==true) continue;
        			visited[x][y]=true;
        			if(board[x][y]==-1){
        				q.add(curr);
        			}else{
        				q.add(board[x][y]);
        			}
        		}        		
        	}
            maxSteps++;
        }
        return -1;
    }
}