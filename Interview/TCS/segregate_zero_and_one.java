import java.util.*;

public class segregate_zero_and_one{
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0};

        int l = 0, r = arr.length - 1;
        
        while(true) {
            if(l >= r){
                break;
            }

            if(arr[l] == 0){
                l++;
            }else if(arr[r] == 1){
                r--;
            }else {
                arr[l] = 0;
                arr[r] = 1;
                l++;
                r--;
            }
        }

        for (int i : arr) {
            System.out.print(i);
        }
    }
}