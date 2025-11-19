import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int T = Integer.parseInt(st.nextToken());
    for(int i=0; i<T; i++){
      st = new StringTokenizer(br.readLine());
      String str = st.nextToken();
      String[] s = str.split("");
      // System.out.println(Arrays.toString(s));
      System.out.println(s[0]+s[s.length-1]);
    }
    
    
  
    

    
    
  }
}
