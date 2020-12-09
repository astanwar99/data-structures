import java.util.Scanner;

//Changes for testing branches - 2(git)
public class CHEFSTR1_chef_and_string{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int n = s.nextInt();
            int[] ar = new int[n];
            Long total = 0l;
            for (int i = 0; i < ar.length; i++)
                ar[i] = s.nextInt();
            for (int i = 1; i < ar.length; i++)
                total += Long.valueOf(Math.abs(ar[i] - ar[i - 1]) - 1);                
            System.out.println(total);
        }
    }
}