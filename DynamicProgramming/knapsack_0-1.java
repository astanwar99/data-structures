import java.util.*;

class Main{
    static int[][] t;

    static int recursiveKnapsack(int[] wt, int[] val, int W, int n) {
        if(n == 0 || W == 0) {
            return 0;
        }

        if(wt[n - 1] <= W) {
            return Math.max(recursiveKnapsack(wt, val, W, n - 1),
                val[n - 1] + recursiveKnapsack(wt, val, W - wt[n - 1], n - 1));
        }
        else{
            return recursiveKnapsack(wt, val, W, n - 1);
        }
    }

    static int recursiveWithMemoizationKnapsack(int[] wt, int[] val, int W, int n){
        if(t[n][W] != -1) {
            return t[n][W];
        }
        if(n == 0 || W == 0) {
            t[n][W] = 0;
            return t[n][W];
        }

        if(wt[n - 1] <= W) {
            t[n][W] = Math.max(recursiveKnapsack(wt, val, W, n - 1),
                val[n - 1] + recursiveKnapsack(wt, val, W - wt[n - 1], n - 1));
            return t[n][W];
        }
        else{
            t[n][W] = recursiveKnapsack(wt, val, W, n - 1);
            return t[n][W];
        }
    }

    static int topDownKnapsack(int[] wt, int[] val, int W, int n) {
        for(int i = 0; i <= n; i++) 
            t[i][0] = 0;
        
        for(int j = 0; j <= W; j++)
            t[0][j] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                if(wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }else{
                    t[i][j] =  t[i - 1][j];
                }
            }
        }

        return t[n][W];
    }

    public static void main(String[] args) {
        int[] val = {10, 15, 40};
        int[] wt = {1, 2, 3};
        int W = 6;
        int n = val.length;

        t = new int[5][100];

        for(int i = 0; i <= n; i++)
        for(int j = 0; j <= W; j++) 
            t[i][j] = -1;

        System.out.println(recursiveKnapsack(wt, val, W, val.length));
        System.out.println(recursiveWithMemoizationKnapsack(wt, val, W, n));
        System.out.println(topDownKnapsack(wt, val, W, n));
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++) 
                System.out.print(t[i][j] + " ");
            System.out.println();
        }

    }
}