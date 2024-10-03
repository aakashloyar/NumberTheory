package Maths;
import java.util.*;
public class EulerTuotient {
    public static void main(String[] args) {
        //fi(n)->number of number less and equal to n are coprime with n
        //fi(n)->n*(1-(1/p1))(1-(1/p2))......(1-(1/pk))  where p1 p2 pk are prime factors of n
        long cnt=ET.func1(10);
        System.out.println(cnt);
    }
}
class ET {
    static long func1(long n) {
        ArrayList<Long> list=new ArrayList<>();
        for(long i=2;i*i<=n;i++) {
            if(n%i==0) {
                list.add(i);
                if(i*i!=n) list.add(n/i);
            }
        }
        long res=n;
        for(int i=0;i<list.size();i++) {
            long p=list.get(i);
            res*=(p-1);
            res/=p;
        }
        return res;
    }
}
