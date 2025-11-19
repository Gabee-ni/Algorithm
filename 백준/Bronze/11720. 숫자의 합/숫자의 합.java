import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    String[] str = (st.nextToken()).split("");
    
    int num =0;
    for(int i=0; i<n ;i++){
      num += Integer.parseInt(str[i]);
    }
    System.out.println(num);
  }
}
