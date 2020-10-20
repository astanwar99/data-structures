import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int countA = 0, countB = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == a){
                countA++;
            }
            else if(nums[i] == b) {
                countB++;
            }
            else if(countA == 0) {
                countA++;
                a = nums[i];
            }
            else if(countB == 0) {
                countB++;
                b = nums[i];
            }
            else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;

        for (int i = 0; i < n; i++) {
            if(nums[i] == a){
                countA++;
            }
            else if(nums[i] == b) {
                countB++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(countA > n / 3) {
            ans.add(a);
        }
        if(countB > n / 3) {
            ans.add(b);
        }
        System.out.println(ans);
    }
}