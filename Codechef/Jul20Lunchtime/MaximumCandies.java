import java.util.*;

public class MaximumCandles {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            int count = 0;
            if(y > x && 2*x >= y) {
                if(n % 2 == 0 || m % 2 == 0) {
                    count = y * n * m / 2;
                }
                else {
                    int a = x;
                    int b = y - x; 
                    count = (a * (m + 1) / 2) + b * (m - 1) / 2;
                }
            }else {
                count = 0;
            }
            System.out.println(count);
        }
    }
}