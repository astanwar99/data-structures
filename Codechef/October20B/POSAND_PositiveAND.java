import java.util.*;

class Main{

    static boolean pow2 (int num)
    {
        return ((num & (num - 1)) == 0);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0) {
            int n = s.nextInt();
            ArrayList<Integer> ans = new ArrayList<>();

            if(pow2(n) && n != 1){
                System.out.println(-1);
                continue;
            }
            if(n == 1) {
                System.out.println(1);
                continue;
            }
            if(n >= 3) {
                ans.add(2);
                ans.add(3);
                ans.add(1);
            }
            if(n > 3) {
                int num = 4;
                while(num <= n) {
                    if(pow2(num)) {
                        ans.add(num + 1);
                        ans.add(num);
                        num += 2;
                    }else{
                        ans.add(num);
                        num++;
                    }
                }
            }   

            for(Integer x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}