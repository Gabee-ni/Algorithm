import java.util.*; 
class Solution {
    static int[] dh = {0,0,-1,1};
    static int[] dw = {-1,1,0,0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int d=0; d<4; d++){
            int nh = h + dh[d];
            int nw = w + dw[d]; 
            if(nh < 0 || nw < 0 || nh >= board.length || nw >= board.length) continue;
            if(board[nh][nw].equals(board[h][w])) answer++;
        }
        return answer;
    }
}