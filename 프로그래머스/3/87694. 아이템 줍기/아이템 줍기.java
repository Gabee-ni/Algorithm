import java.util.*;
class Solution {
    int[][] map = new int[102][102];
    boolean[][] visited = new boolean[102][102];
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                
                    boolean isBorder = x == x1 || x == x2 || y == y1 || y == y2;
                
                    if (isBorder) {
                        if (map[x][y] != 2) {
                            map[x][y] = 1;
                        }
                    } else {
                        map[x][y] = 2;
                    }
                }
            }
        }
        
        int startX = characterX * 2;
        int startY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;
        
        int distance = bfs(startX, startY, targetX, targetY);
        
        return distance / 2;
    }
    
    public int bfs(int startX, int startY, int targetX, int targetY){
        Deque<int[]> q = new ArrayDeque<>(); 
        q.offer(new int[]{startX, startY,0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if (x == targetX && y == targetY) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                // 테두리인 곳만 이동 가능
                if (map[nx][ny] != 1) {
                    continue;
                }
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        return -1;
    }
}