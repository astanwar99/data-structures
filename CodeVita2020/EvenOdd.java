import java.util.*;

public class EvenOdd{

    static int solve(int nE, int nO, int k, boolean flag) {
        if(k == 1 && flag) {
            return nE;
        }
        if(k == 1 && !flag) {
            return nO;
        }
        if(flag) {
            return nE * solve(nE, nO, k - 1, !flag);
        }else {
            return nO * solve(nE, nO, k - 1, !flag);
        }
        
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int h = s.nextInt();
        int k = s.nextInt();
        int nE, nO;
        int n = h - l + 1;
        if(n % 2 == 0) {
            nE = n / 2;
            nO = n / 2;
        }
        else {
            if(l % 2 == 0) {
                nE = (n + 1) / 2;
                nO = n - nE;
            }
            else {
                nO = (n + 1) / 2;
                nE = n - nO;
            }
        }
        if(k % 2 == 0)
            System.out.println(solve(nE, nO, k, false) + solve(nE, nO, k, true));
        else {
            System.out.println((nE + nO) * (solve(nE, nO, k, false) + solve(nE, nO, k, true)));
        }

    }
}