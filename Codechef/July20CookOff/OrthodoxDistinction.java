import java.util.HashSet;
import java.util.Scanner;

public class OrthodoxDistinction {

    private static boolean distinction(long[] ar, int n) {
        HashSet<Long> h = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(!h.add(ar[i])) {
                return false;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long or = ar[i];
                for (int k = i + 1; k <= j; k++) {
                    or |= ar[k];
                }
                if(!h.add(or)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int n = s.nextInt();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = s.nextLong();
            }
            boolean ans = distinction(ar, n);
            if(ans) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}