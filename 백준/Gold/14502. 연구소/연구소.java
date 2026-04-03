import java.util.*; 
import java.io.*; 

class Main {
    static int answer, N,M;
    static int[][] map;
    static int[] di ={-1,1,0,0};
    static int[] dj = {0,0,-1,1}; 
    static  List<Loc> list;
    static class Loc {
        int i;
        int j;
        
        Loc(int i, int j){
            this.i = i;
            this.j = j;
        }
       
    }
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j]==2) list.add(new Loc(i,j)); 
            }
        }
        
        makeWall(0); 
        System.out.println(answer); 
    }
    
    static void makeWall(int wall){
        if(wall == 3) {
            //BFS
            int[][] map2 = new int[N][M]; 
            int count=0; 
            for(int i=0; i<N; i++){
                map2[i] = map[i].clone();
            }
            
            Queue<Loc> queue = new ArrayDeque<>();
            for(Loc l : list){
                queue.offer(l); 
            }
            
            while(!queue.isEmpty()){
                Loc cur = queue.poll(); 
                
                for(int d=0; d<4;d++){
                    int ni = cur.i + di[d];
                    int nj = cur.j + dj[d]; 
                    
                    if(ni<0||nj<0||ni>=N||nj>=M) continue;
                    if(map2[ni][nj]==0) {
                        map2[ni][nj] = 2;
                        queue.offer(new Loc(ni, nj)); 
                    }
                }
            }
            
           for(int i =0 ; i<N; i++){
            for(int j=0; j<M; j++){
               if(map2[i][j] ==0 ) count++; 
            }
        }
            answer = Math.max(answer, count); 
            return;             
        }
        
        for(int i =0 ; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1; 
                    makeWall(wall+1);
                    map[i][j] = 0; 
       
                }
            }
        }
    }
}