import java.util.*;

public class maximum_stolen_money {

    int find_max(int[] ar, int in){
        if(in >= ar.length){
            return 0;
        }

        return Math.max(find_max(ar, in + 1), ar[in] + find_max(ar, in + 2));
    }

    int find_max_dp(int[] ar){
        int[] dp = new int[ar.length];
        dp[0] = ar[0];
        dp[1] = ar[1];

        for(int i = 2; i < ar.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + ar[i]);
        }
        return dp[ar.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 3, 6, 4};
        maximum_stolen_money m = new maximum_stolen_money();
        int sum1 = m.find_max(arr, 0);
        int sum2 = m.find_max_dp(arr);
        System.out.println(sum2 + " " + sum1);
    }
}