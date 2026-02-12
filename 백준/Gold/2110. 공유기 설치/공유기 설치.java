import java.util.*; 
import java.io.*;
class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] home = new int[N];
        
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            home[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(home);
        
        int start =0, end =1000000000;
        int answer = 0; 
        
        while (start <= end){
            int mid = (start + end)/2;
            int install = 1; //x1번 집 부터 설치
            int prev = home[0];
            
            for (int i=1; i<home.length; i++){
                if(home[i] - prev >= mid ){
                    install++;
                    prev = home[i];
                }
            } 
            
            if (install < C ){ 
                end = mid-1;                
            }  else {
                answer = mid; 
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}