import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for(int i=0; i<N;i++){
      arr[i] = i+1;
    }

    
    for(int i=0;i<M;i++){
      st = new StringTokenizer(br.readLine());
      
      int num1 = Integer.parseInt(st.nextToken())-1;
      int num2 = Integer.parseInt(st.nextToken())-1;
      int temp =0;

      temp = arr[num1];
      arr[num1] = arr[num2];
      arr[num2] = temp;
      
    }
    
    for(int i=0; i<N;i++){
      System.out.print(arr[i]+" ");
    }
  }
}
