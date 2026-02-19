import java.util.*;

class Solution {
    static int id=1; 
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[][] visited; 
    
    public int solution(int[][] land) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        visited = new int[land.length][land[0].length];
        for(int j=0; j<land[0].length; j++){
            for(int i=0; i<land.length; i++){
                if(land[i][j] ==1 && visited[i][j] ==0){
                    int size = dfs(j,i,0,land);
                    map.put(id, size);
                    id++;
                }
            }
        }
        
         for(int j=0; j<land[0].length; j++){
            Set<Integer> set = new HashSet<>(); 
            int totalSum= 0;
            for(int i=0; i<land.length; i++){
                if(land[i][j] == 1&& !set.contains(visited[i][j])){
                    totalSum += map.get(visited[i][j]);
                    set.add(visited[i][j]);
                }
            }
             answer = Math.max(answer, totalSum);
        }
        
        
        
        return answer;
    }
    
    public int dfs(int j, int i, int cnt, int[][] land){
        if(visited[i][j] != 0) return cnt;
        
        visited[i][j] = id; 
        cnt+=1;
        
        for(int d=0; d<4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            
            if(ni<0 || nj <0 || ni >= land.length || nj >= land[0].length ||visited[ni][nj]!=0) continue;
            if(land[ni][nj] ==1) {
                cnt = dfs(nj, ni, cnt, land);
            }
        }
        
        return cnt;
        
    }
}