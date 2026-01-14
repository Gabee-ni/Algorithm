import java.util.*;

class Pos{
    public int i;
    public int j;
    
    Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    static int[] di={-1,1,0,0}, dj={0,0,-1,1};
    
    public int solution(int[][] maps) {
        
        int[][] visited = new int[maps.length][maps[0].length];
		
        return bfs(new Pos(0,0), maps, visited);
   
    }
    
    public static int bfs(Pos pos, int[][] maps, int[][] visited){
        Queue<Pos> queue = new LinkedList<>();
        
        queue.offer(pos);
        visited[pos.i][pos.j] = 1;
        
        while(!queue.isEmpty()){
        
            Pos s = queue.poll();
            
            if(s.i== maps.length-1  && s.j==maps[0].length-1) return visited[s.i][s.j];
            
            for(int d=0; d<4; d++){
                int ni = s.i + di[d];
                int nj = s.j + dj[d];
                
                if(ni>=0 && ni < maps.length && nj>=0 && nj < maps[0].length &&
                   maps[ni][nj]==1 && visited[ni][nj]==0){
                    queue.offer(new Pos(ni,nj));
                    visited[ni][nj] = visited[s.i][s.j] + 1;
                }
            }
        }
        return -1;   
    }
    
}