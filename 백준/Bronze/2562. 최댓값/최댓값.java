import java.util.*;
import java.io.*;

class Pos{
  public int num;
  public int idx;

  Pos(int num, int idx){
    this.num = num;
    this.idx = idx;
  }
}


public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ; 

    Pos[] pos = new Pos[9];
    for(int i=0; i<9;i++){
      st = new StringTokenizer(br.readLine()); 
      int n = Integer.parseInt(st.nextToken());
      pos[i] = new Pos(n, i);
      
    }
    Arrays.sort(pos, (o1,o2)->{
        return o2.num - o1.num;
    });
    System.out.println(pos[0].num+"\n"+ (pos[0].idx+1));
  }
}

