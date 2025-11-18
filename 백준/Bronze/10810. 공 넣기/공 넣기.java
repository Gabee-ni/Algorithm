import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for(int i=0; i<M;i++){
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken()) -1;
      int end = Integer.parseInt(st.nextToken()) -1;
      int num = Integer.parseInt(st.nextToken());

      for(int j=start; j<=end; j++){
        arr[j] = num;
      }
    }

      for(int n : arr){
        System.out.print(n+" ");
      }
    
    
  }
}
