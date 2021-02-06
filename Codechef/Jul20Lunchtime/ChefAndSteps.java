import java.util.*;

public class ChefAndSteps{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        while(T-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            String str = "";
            for (int i = 0; i < n; i++) {
                if(s.nextInt() % k == 0) {
                    str += "1";
                }else {
                    str += "0";
                }
            }
            System.out.println(str);
        }
    }
}