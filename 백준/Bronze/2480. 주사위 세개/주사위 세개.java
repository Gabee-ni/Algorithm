import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int num1 = Integer.parseInt(st.nextToken());
    int num2 = Integer.parseInt(st.nextToken());
    int num3 = Integer.parseInt(st.nextToken());
    int prize = 0;

    if(num1 == num2 && num2 ==num3) prize = num1*1000 + 10000;
    else if(num1==num2 && num1 != num3) prize = num1*100 + 1000;
    else if(num2==num3 && num1 != num2) prize = num2*100 + 1000;
    else if(num3==num1 && num1 != num2) prize = num3*100 + 1000;
    else prize = Math.max(Math.max(num1,num2),num3)*100;

    System.out.println(prize);
    
  }
}
