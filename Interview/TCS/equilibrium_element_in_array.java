import java.util.*;

class equilibrium_element_in_array{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3};
        int[] pre = new int[arr.length];
        int[] suf = new int[arr.length];

        pre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        suf[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            suf[i] = suf[i + 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if(pre[i] == suf[i]){
                System.out.println(arr[i]);
                break;
            }            
        }
    }
}