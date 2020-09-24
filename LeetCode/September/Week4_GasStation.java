import java.util.*;

class Main{

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        for(int i = 0; i < n; i++) {
            int j = i;
            int tank = 0;
            boolean flag = true;
            do {
                tank = tank + gas[j] - cost[j];
                if(tank < 0) {
                    flag = false;
                    break;
                }
                j = (j + 1) % n;
            } while (j != i);
            
            if(flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];
        
        for(int i = 0; i < n; i++) {
            gas[i] = s.nextInt();
        }

        for(int i = 0; i < n; i++) {
            cost[i] = s.nextInt();
        }

        System.out.println(canCompleteCircuit(gas, cost));
    }
}