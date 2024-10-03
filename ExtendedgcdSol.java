package Maths;
import java.util.*;
public class ExtendedgcdSol {
    public static void main(String[] args) {
        long res[]=Diophantine.func1(66,48);
        System.out.println(Arrays.toString(res));
    }
}
class Diophantine {
    static long[] func1(long a,long b) {
        if(b==0) {
            //x=1,y=0//gcd =a;
            return new long[]{1,0,a};
        }
        long[] temp=func1(b,a%b);
        long x1=temp[0],y1=temp[1],g=temp[2];
        long x=y1,y=x1-y1*(a/b);
        return new long[]{x,y,g};
    }
}
