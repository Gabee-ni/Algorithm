import java.util.*;
class Solution {
    public int solution(int[][] dots) {
       
        int m1 = 0, m2 =0;
        double[] slopes = new double[3];
        
        slopes[0] = getSlope(dots[0], dots[1], dots[2], dots[3]);
        slopes[1] = getSlope(dots[0], dots[2], dots[1], dots[3]);
        slopes[2] = getSlope(dots[0], dots[3], dots[1], dots[2]);
        
        for (double s : slopes) {
            if (s == 1.0) return 1; 
        }
        return 0;
    }
    
    public double getSlope(int[] a, int[] b, int[] c, int[] d){
        double slope1 = (double)(a[1] - b[1])/(a[0]-b[0]);
        double slope2 = (double)(c[1] - d[1])/(c[0]-d[0]);
        
        return (slope1==slope2)? 1.0 : 0.0;
        
    }
}