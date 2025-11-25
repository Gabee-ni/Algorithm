import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    String[] first = st.nextToken().split("");
    String[] second = st.nextToken().split("");

    String temp1 = "";
    String temp2 = "";
    
    for(int i=first.length-1; i>=0; i--){
      temp1 += first[i];
    }
     for(int i=second.length-1; i>=0; i--){
      temp2 += second[i];
    }

    
    if ( Integer.parseInt(temp1)>  Integer.parseInt(temp2)) System.out.println(temp1);
    else System.out.println(temp2) ;
  }
}
