import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] arr = new int[9][9];
		int max =0; 
		int row = 0, col = 0;
		
		for(int i=0; i<arr.length;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<arr.length;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>=max) {
					max = arr[i][j];
					row = i+1;
					col = j+1;
				}
				
			}
		}
		
		System.out.println(max);
		System.out.println(row+" "+col);
	}

}
