import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    String s = st.nextToken();
    String[] str = s.split("");

    for(int i=97; i<97+26;i++){
        if(s.contains(Character.toString((char)i))) {
          System.out.print(s.indexOf((char)i)+" ");
        }else System.out.print(-1 + " ");
    }
  }
}
