import java.util.*;

class second_max_number{
    public static void main(String[] args) {
        int[] arr = {12, 5, 7, 10, 90};

        int sec_max = 0;
        for(int j = 0; j < 2; j++) {
            int max = 0;
            int index = 0;
            for(int i = 0; i < arr.length; i++) {
                if(max < arr[i]){
                    max = arr[i];
                    index = i;
                }
            }
            sec_max = max;
            arr[index] = 0;
        }
        System.out.println(sec_max);        
    }
}