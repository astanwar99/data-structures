import java.util.*;
public class InxorableTask {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int n = s.nextInt();
            int q = s.nextInt();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = s.nextLong();
            }
            int[][] dp = new int[n][n];
            for (int i = 0; i < q; i++) {
                int l = s.nextInt() - 1;
                int r = s.nextInt() - 1;
                int  ans = task(ar, n, l, r, dp);
                System.out.println(ans);
            }
        }
    }

    private static int task(long[] ar, int n, int l, int r, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        if(dp[l][r] == 0){
            int count = 0;
            for (int i = l; i <= r; i++) {
                for (int j = l; j <= r; j++) {
                    long xor = ar[i] ^ (ar[j]);
                    if(ar[i] <= xor && ar[j] >= xor) {
                        count++;
                        dp[i][j] = count;
                    }
                }
            }
            return count;
        }
        else {
            return dp[l][r];
        }
        
    }
}