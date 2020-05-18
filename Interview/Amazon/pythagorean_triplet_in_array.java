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

    boolean sol3_hashing(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int max = 0;
        int[] ar = arr.clone();
        for (int i = 0; i < ar.length; i++) {
            max = Math.max(max, ar[i]);
            hmap.put(ar[i], 0);
        }
        for (int i : ar) {
            hmap.put(i, hmap.get(i) + 1);
        }

        for(int i = 1; i < max + 1; i++) {
            if(hmap.get(i) == null)
                continue;
            
            for(int j = 1; j < max + 1; j++) {
                if(hmap.get(j) == null || (hmap.get(i) == hmap.get(j) && hmap.get(i) < 2)){
                    continue;
                }

                // Find c 
                int val = (int) Math.sqrt(i * i + j * j); 
    
                // If c^2 is not a perfect square 
                if ((val * val) != (i * i + j * j)) 
                    continue; 
    
                // If c exceeds the maximum value 
                if (val > max) 
                    continue; 
                
                if(hmap.get(val) == 1)
                    return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5 };
        Test t = new Test();
        t.sol1_brute_method(arr);
        t.sol2_sorting(arr);
        System.out.println(t.sol3_hashing(arr));
    }
}