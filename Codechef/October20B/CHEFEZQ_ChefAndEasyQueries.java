import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long t = s.nextLong();
        
        while(t-- > 0){
            int n = s.nextInt();
            long k = s.nextLong();

            long task[] = new long[n];
            long total = 0, ans = 0;
            boolean flag = false;
            
            for(int i = 0; i < n; i++){
                task[i] = s.nextLong();
                total += task[i];
            }
            
            for(int i = 0; i < n - 1; i++){
                if(task[i] < k){
                    ans = i;
                    flag = true;
                    break;
                }
                task[i + 1] += task[i] - k;
            }
                
            if(flag){
                System.out.println(ans + 1);
            }
            else{
                System.out.println((total / k) + 1);
            }
            
        }
    }
}