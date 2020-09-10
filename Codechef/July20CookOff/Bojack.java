import java.util.*;

public class Bojack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int n = s.nextInt();
            StringBuffer str = new StringBuffer(2*n + 1);
            for (int i = 0; i < n; i++) {
                str.append('a');
            }
            for (int i = 0; i < n; i++) {
                str.append('b');
            }
            System.out.println(2*n);
            System.out.println(str);
        }
    }
}