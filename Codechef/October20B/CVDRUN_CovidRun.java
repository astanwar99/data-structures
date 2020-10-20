import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();

            boolean flag = false;

            for (int i = 0; i < 1000; i++) {
                if((x + k) % n != y) {
                    x = (x + k) % n;
                }
                else {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}