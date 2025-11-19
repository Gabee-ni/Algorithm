import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt =0;
    String[] str = br.readLine().split(" ");
    for(String s : str){
      if(s =="") continue;
      else cnt++;
    }
    System.out.println(cnt);
  }
}
