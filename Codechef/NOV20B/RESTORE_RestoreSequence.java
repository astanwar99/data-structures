import java.util.*;

public class RESTORE_RestoreSequence {
    static ArrayList<Integer> sieveOfEratosthenes(int lim) {
        boolean[] p = new boolean[lim];
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < lim; i++)
            p[i] = true;
        for (int i = 2; i * i < lim; i++)
            if(p[i])
                for (int j = i * i; j < lim; j+=i)
                    p[j] = false;
        for (int i = 2; i < lim; i++)
            if(p[i])
                primeNumbers.add(i);
        return primeNumbers;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int nlim = 4000001;
        ArrayList<Integer> p = sieveOfEratosthenes(nlim);

        while(t-- > 0) {
            int n = s.nextInt();
            int[] ar = new int[n];
            HashMap<Integer, Integer> hmap = new HashMap<>();
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ar[i] = s.nextInt();
                if(hmap.containsKey(ar[i]))
                    hmap.put(ar[i], hmap.get(ar[i]) + 1);
                else 
                    hmap.put(ar[i], 1);
            }
            for (int i = 0; i < n; i++) {
                ans.add(p.get(ar[i]));
                hmap.put(ar[i], hmap.get(ar[i]) - 1);
            }
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
        
    }
}
