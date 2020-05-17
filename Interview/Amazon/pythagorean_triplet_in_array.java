import java.util.*;

class Test{
    boolean sol1_brute_method(int[] arr){
        int[] ar = arr.clone();
        int a, b, c;
        for (int i : ar) {
            for (int j : ar) {
                for (int k : ar) {
                    a = i * i;
                    b = j * j;
                    c = k * k;

                    if(a == b + c || b == a + c || c == a + b){
                        System.out.println("Triplet found: " + a + ", " + b + ", " + c);
                        return true;
                    }
                }
            }
        }
        System.out.println("No triplet found");
        return false;
    }

    boolean sol2_sorting(int[] arr) {
        int[] ar = arr.clone();
        int a, b, c;
        int f, l;
        Arrays.sort(ar);
        for (int i = 0; i < ar.length; i++) {
            ar[i] = ar[i] * ar[i];
        }

        for (int i = ar.length - 1; i > 0; i--) {
            c = ar[i];
            f = 0;
            l = i - 1;
            a = ar[f];
            b = ar[l];
            while(b >= a) {
                a = ar[f];
                b = ar[l];
                if(a + b == c){
                    System.out.println("Triplet found: " + a + ", " + b + ", " + c);
                    return true;
                }
                else if(a + b < c){
                    f++;
                }
                else if(a + b > c){
                    l--;
                }
            }
        }
        System.out.println("No triplet found");
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };
        Test t = new Test();
        t.sol1_brute_method(arr);
        t.sol2_sorting(arr);
    }
}