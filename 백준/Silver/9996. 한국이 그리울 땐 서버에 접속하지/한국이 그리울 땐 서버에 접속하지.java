import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split("\\*");
        String prefix = str[0];
        String suffix = str[1];

        for (int i = 0; i < N; i++) {
            String inputStr = br.readLine();

            if (inputStr.length() < prefix.length() + suffix.length()) {
                System.out.println("NE");
                continue;
            }

            if (inputStr.startsWith(prefix) && inputStr.endsWith(suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
  
    }
 
}