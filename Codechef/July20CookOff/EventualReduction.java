import java.util.HashMap;
import java.util.Scanner;

public class EventualReduction {

    static boolean reduction(String str, int l){
        HashMap<Character, Integer> h = new HashMap<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < l; i++) {
            if(h.containsKey(ch[i])) {
                h.replace(ch[i], h.get(ch[i]) + 1);
            }
            else {
                h.put(ch[i], 1);
            }
        }
        for (Integer count : h.values()) {
            if(count % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- > 0) {
            int l = s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            boolean ans = reduction(str, l);
            if(ans) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}