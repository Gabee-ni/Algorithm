class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[] dRow = {0,1,0,-1}; //우하좌상
        int[] dCol = {1,0,-1,0};
        int dir = 0;
        int num =1; 
        int row=0, col=0;
        
        while(num<=n*n){
            answer[row][col] = num++;
            
            int nRow = row + dRow[dir%4];
            int nCol = col + dCol[dir%4];
            
            if(nRow<0 || nRow >= n || nCol<0 || nCol >=n ||answer[nRow][nCol] != 0){
                dir++;
                 nRow = row + dRow[dir%4];
                 nCol = col + dCol[dir%4];
            }
            row = nRow;
            col = nCol;
        }
        return answer;
    }
}