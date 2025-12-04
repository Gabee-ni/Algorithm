import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long result = factorial(N);
		System.out.println(result);
		
	}
	
	public static long factorial(int depth) {
		
		if(depth <= 1) return 1;
		return depth*factorial(depth-1);
	}

}
