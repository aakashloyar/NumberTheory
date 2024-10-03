package Maths;
import java.util.*;
public class SegmentedSeive {
    public static void main(String[] args) {
        //when l and r are very large nearly <=10^12
        //when r-l<=10^6
        ArrayList<Long> list=Seg_Seive.func1((long)1e8,(long)1e8+3000);
        System.out.println(list);
    }
}
class Seg_Seive {
//    long l,r;
//    Seg_Seive(long l,long r) {
//        this.l=l;
//        this.r=r;
//    }
    static ArrayList<Long> func1(long l,long r) {

        //step->1 Get all the prime number less than root(r)
        int pivot=(int)Math.sqrt(r);
        boolean[] v=new boolean[pivot+1];
        for(int i=2;i<=pivot;i++) {
            if(!v[i]) {
                for(int j=2;j*i<=pivot;j++) v[j*i]=true;
            }
        }
        ArrayList<Integer> prime=new ArrayList<>();
        for(int i=2;i<=pivot;i++) if(!v[i]) prime.add(i);
        //step->2 mark all the composite number between l to r as visited
        v=new boolean[(int)(r-l+1)];
        //System.out.println(v.length);
        for(Integer p:prime) {
            long s=(((l+p-1)/p)*p);//taking the starting point greater than r
            s=Math.max(s,(long)p*p);//till square of p already visited by smaller prime
            //eg-> 21 3*7  is visited by 3<7 so 7 will visit only number-> 7*x .. x>=7
            //means start visited from 7*7
            for(s=s;s<=r;s+=p) {
                v[(int)(s-l)]=true;
            }
        }
        //step->3 return all the unmarked no
        ArrayList<Long> res=new ArrayList<>();
        for(int i=0;i<v.length;i++) {
            if(!v[i]) res.add(l+i);
        }
        return res;
    }
}
