import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[] student = new int[30];

    for(int i=0;i<28; i++){
      st = new StringTokenizer(br.readLine());  
      student[Integer.parseInt(st.nextToken()) -1] ++;
    }
    
    int cnt =0;
    for(int i=0; i<30; i++){
      if(cnt == 2) break;
      if(student[i]==0) {
        System.out.println((i+1));
        cnt ++; 
      }
    }
    
    
  }
}
