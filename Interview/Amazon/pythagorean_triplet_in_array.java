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

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };
        Test t = new Test();
        t.sol1_brute_method(arr);
        // t.sol2_sorting(arr);
    }
}