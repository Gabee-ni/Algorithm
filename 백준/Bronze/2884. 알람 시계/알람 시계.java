import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int H = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    if(M-45 <0){
      H--;
      if(H<0) H=23;
      M = 60-(45-M);
    }else {
      M= M-45;
    }
    System.out.println(H+" "+M);
  }
}
