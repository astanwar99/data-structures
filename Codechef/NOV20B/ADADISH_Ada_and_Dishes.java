import java.util.*;

class Main{

    static int min(int[] ar, int n, int sumc, int sum) {
        if(n == 0) {
            return Math.abs((sum - sumc) - sumc);
        }

        return Math.min(min(ar, n - 1, sumc + ar[n - 1], sum),
                        min(ar, n - 1, sumc, sum));

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0) {
            int n = s.nextInt();
            int[] ar = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = s.nextInt();
                sum += ar[i];
            }
            int ans = Integer.MAX_VALUE;
            if(n == 1){
                ans = ar[0];
            }else if (n == 2){
                ans = Math.max(ar[0], ar[1]);
            }else {
                Arrays.sort(ar);

                int d = min(ar, n, 0, sum);
                double h = sum / 2;
                double dh = d / 2;
                h = h - dh + d;
                ans = (int)h;
            }
            
            System.out.println(ans); 
        }
    }
}