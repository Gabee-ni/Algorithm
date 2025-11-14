import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int C = Integer.parseInt(st.nextToken());

    int newH=0, newM = 0;
    int H=0, M =0;

    newM = B+(C%60);
    if(newM >= 60) {
      M = newM % 60;
      newH += newM / 60;
    }else M = newM;
    newH += A+(C/60);
    if(newH >=24){
      H = newH%24;
    }else H = newH;
    System.out.println(H + " "+M);
    
  }
}
