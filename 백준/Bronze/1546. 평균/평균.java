import java.util.*;
import java.io.*;
public class Main{
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());  

    int N = Integer.parseInt(st.nextToken());
    double[] score = new double[N];
    double max = 0.0; 

    st = new StringTokenizer(br.readLine());  
    for(int i=0; i<N;i++){
      score[i] = Double.parseDouble(st.nextToken()) ; 
      max = Math.max( max, score[i]);
    }
    double totalSum =0.0;
    for(double num : score){
      totalSum += (num/max) * 100.0;
    }
    double answer =  Math.round(totalSum / (double)N * 1_000_000) / 1_000_000.0;
    System.out.println(answer);

  }
}
