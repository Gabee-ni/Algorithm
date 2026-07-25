import java.util.*; 

class Solution {
    static class Pos {
        int i;
        int j;
        
        Pos(int i, int j){
            this.i = i; 
            this.j = j;
        }
    }
    int[] di ={-1,1,0,0}, dj={0,0,-1,1}; 
    public int solution(int[][] maps) {
        int dist = bfs(0,0,maps[0][0],maps);
        
        return dist;
    }
    
    private int bfs(int ci, int cj, int cost, int[][] maps){
        Deque<Pos> q = new ArrayDeque<>(); 
        
        q.offer(new Pos(ci, cj));
        
        while(!q.isEmpty()){
            Pos cur = q.poll(); 
            
            if(cur.i == maps.length-1 && cur.j ==maps[0].length-1) return maps[cur.i][cur.j];
            
            for(int d=0; d<4; d++){
                int ni = cur.i + di[d]; 
                int nj = cur.j + dj[d];

                if(ni < 0 || nj < 0 || ni>=maps.length || nj >= maps[0].length) continue;
                if(maps[ni][nj] == 0 || maps[ni][nj] != 1) continue; 
                
                maps[ni][nj] = maps[cur.i][cur.j] + 1;
                q.offer( new Pos(ni, nj));
            }
        }
        return -1;
    }
}