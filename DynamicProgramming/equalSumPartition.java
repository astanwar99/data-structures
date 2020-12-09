import jdk.nashorn.internal.ir.ReturnNode;

public class equalSumPartition {

    static boolean[][] t;
    
    static boolean recursive(int sum, int[] ar, int n) {
        if(sum == 0)
            return true;
        
        if(n == 0)
            return false;

        if(ar[n - 1] <= sum) {
            return recursive(sum - ar[n - 1], ar, n - 1) ||
                    recursive(sum, ar, n - 1);
        }else {
            return recursive(sum, ar, n - 1);
        }
    }

    static boolean recursiveWithMemoization(int sum, int[] ar, int n) {
        if(sum == 0 || n == 0) 
            return t[n][sum];
        
        if(ar[n - 1] <= sum) 
            t[n][sum] = recursiveWithMemoization(sum - ar[n - 1], ar, n - 1) ||
                        recursiveWithMemoization(sum, ar, n - 1);
        else t[n][sum] = recursiveWithMemoization(sum, ar, n - 1);

        return t[n][sum];
    }

    static boolean topDown(int sum, int[] ar, int n) {
        for (int i = 0; i <= n; i++) 
            t[i][0] = true;
        for (int i = 1; i <= sum; i++) 
            t[0][i] = false;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                t[i][j] = t[i - 1][j];
                if(ar[i - 1] <= j)
                    t[i][j] = t[i - 1][j - ar[i - 1]] || t[i][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] ar = {1, 5, 11, 5, 4};
        int n = ar.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }
        boolean ans;

        t = new boolean[n + 1][sum / 2 + 1];

        ans = recursive(sum / 2, ar, n);
        System.out.println(ans);

        for (int i = 0; i <= n; i++) 
            t[i][0] = true;
        for (int i = 1; i <= sum / 2; i++) 
            t[0][i] = false;
        ans = recursiveWithMemoization(sum / 2, ar, n);
        System.out.println(ans);

        ans = topDown(sum / 2, ar, n);
        System.out.println(ans);
        
    }
}
