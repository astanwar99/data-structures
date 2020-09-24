import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            int l = s.nextInt();

            if(k * l < n) {
                System.out.println("-1");
            }
            else{
                int r = (n % k);
                int q = n / k;
                // System.out.println(q + " " + (n % k) + " " + (k % n));
                for(int i = 0; i < q; i++) {
                    for(int j = 1; j <= k; j++) {
                        System.out.print(j + " ");
                    }
                }
                for(int i = 1; i <= r; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }

        }
    }
}