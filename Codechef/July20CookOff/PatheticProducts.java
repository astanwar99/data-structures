import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PatheticProducts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int n = s.nextInt();
            
            Integer[] u = new Integer[n - 1];
            Integer[] v = new Integer[n - 1];

            for (int i = 0; i < n - 1; i++) {
                u[i] = s.nextInt();
                v[i] = s.nextInt();
            }
            getNodeValues(u, v, n);
        }
    }

    private static void getNodeValues(Integer[] u, Integer[] v, int n) {
        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();

        p1.add(u[0]);
        p2.add(v[0]);
        for (int i = 1; i < n - 1; i++) {
            if(p1.contains(u[i])){
                p2.add(v[i]);
            }
            else if(p2.contains(u[i])) {
                p1.add(v[i]);
            }
            else if(p1.contains(v[i])){
                p2.add(u[i]);
            }
            else {
                p1.add(u[i]);
                p2.add(v[i]);
            }
        }
        
        long a = 1l, b = 1l;
        boolean[] p = new boolean[100];
        for (int j = 2; j*j < 100; j++) {
            if(!p[j]) {
                for (int j2 = j*j; j2 < 100; j2 += j) {
                    p[j2] = true;
                }
            }
        }
        for (int i = 97; i > 1; i--) {
            if(!p[i]){
                if(a < b) {
                    System.out.println("a " + i + " " + a);
                    a *= (long)i;
                }else {
                    System.out.println("b " + i + " " + b);
                    b *= (long)i;
                }
            }
        }
        boolean[] ans = new boolean[n];
        for (Integer integer : p1) {
            ans[integer] = true;
        }
        for (boolean c : ans) {
            if(c) {
                System.out.print(a + " ");
            }else {
                System.out.print(b + " ");
            }
        }
        System.out.println();
    }
}