import java.util.*;
import java.io.*; 

class Main {
    static class Location {
        int li; 
        int lj; 
        
        Location(int li, int lj){
            this.li = li; 
            this.lj = lj;
        }
    }
    
    static int[][] board; 
    static int answer, N, M; 
    static List<Location> list; 
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1}; 
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(); 
        board = new int[N][M]; 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for( int j=0; j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2) list.add(new Location(i,j));
            }
        }
        
        makeWall(0); 
        System.out.println(answer);
    }
    static void makeWall(int count){
        if(count==3){
            
            int[][] board2 = new int[N][M]; 
            for(int i=0; i<N; i++){
                board2[i] = board[i].clone();  
            }
            
            Queue<Location> queue = new ArrayDeque<>(); 
            for(Location l : list) {
                queue.offer(l); 
            }
            
            while(!queue.isEmpty()){
                Location cur = queue.poll(); 
                
                for(int d=0; d<4; d++){
                    int ni = cur.li + di[d]; 
                    int nj = cur.lj + dj[d]; 
                    
                    if(ni <0 || nj <0 || ni >=N || nj >=M ) continue;
                    if (board2[ni][nj] ==0) {
                        board2[ni][nj] =2;
                        queue.offer(new Location(ni, nj));
                    }
                }
            }
            
            int cnt =0; 
         for(int i=0; i<N; i++){
            for( int j=0; j<M;j++){
                if(board2[i][j]==0) cnt++; 
            }
        }
            answer = Math.max(cnt, answer); 
            
            return; 
        }
        
        for(int i=0; i<N; i++){
            for( int j=0; j<M;j++){
                if(board[i][j] == 0) {
                    board[i][j] =1; 
                    makeWall(count+1); 
                    board[i][j] = 0; 
                }
         
            }
        }
        
        
    }
}