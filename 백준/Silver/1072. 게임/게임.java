import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args ) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long Z = (Y*100) / X ;
        
        if (Z >= 99){ 
            System.out.println(-1);
            return;
        }
        
        long result = 0; 
        long start = 1;
        long end = 1000000000L;
        long m = (start+end)/2;
        
        while(start <= end){
            m = (start+end)/2;
            long newScore = (Y+m)*100/(X+m);
            if( newScore > Z ) {
                end = m-1;
                result = m;
            } else {
                start = m+1;
            }
        }
        System.out.println(result);
    }
}