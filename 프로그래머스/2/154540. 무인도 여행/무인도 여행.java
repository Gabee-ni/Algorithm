import java.util.*; 
class Solution {
    int[] di = {-1,1,0,0}, dj = {0,0,-1,1}; 
    List<Integer> list = new ArrayList<>(); 
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length();j++){
                
                if(maps[i].charAt(j) == 'X') continue; 
                if(visited[i][j]) continue;
                
                int sum = dfs(i, j, maps);
                list.add(sum);
            }
        }
        
        if(list.isEmpty()) return new int[]{-1}; 
        
        Collections.sort(list); 
        
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public int dfs(int ci, int cj, String[] maps){
 
        visited[ci][cj] = true; 
        
        int sum = maps[ci].charAt(cj) - '0'; 
        
        for(int d=0; d<4; d++){
            int ni = ci + di[d];
            int nj = cj + dj[d]; 
            
            if(ni < 0 || nj < 0 || ni >= maps.length || nj >= maps[0].length()) continue;   
            
            if(maps[ni].charAt(nj) == 'X') continue; 
            if(visited[ni][nj]) continue; 
            
            sum += dfs(ni, nj, maps);
        }
        return sum;
    }
}