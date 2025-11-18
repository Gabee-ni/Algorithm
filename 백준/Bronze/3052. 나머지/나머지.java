import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[] arr = new int[42];
    
    for(int i=0; i<10;i++){
      st = new StringTokenizer(br.readLine()); 
      int num = Integer.parseInt(st.nextToken());
      arr[num % 42]++;
    }

    int cnt =0; 
    for(int n :  arr){
      if(n!=0) cnt++;
    }
    System.out.println(cnt);
  }
}
