import java.util.*;
class Main{

    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int i = 1; i <= n; i+=2) {
            for(int k = 0; k < n; k++) {
                for(int j = k; j < k + i && k + i <= n; j++){
                    sum += arr[j];
                    // System.out.print(arr[j] + " ");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = s.nextInt();
        }

        System.out.println(sumOddLengthSubarrays(ar));
    }
}