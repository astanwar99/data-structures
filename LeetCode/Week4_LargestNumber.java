import java.util.*;

class Main{
    public static String largestNumber(int[] nums) {
        List<String> num = new ArrayList<>(nums.length);
        for (int i : nums) num.add(String.valueOf(num));
        Collections.sort(num, new Comparator<String>(){
            public int compare(String d1, String d2) {
                for(int i = 0, j = 0; i < d1.length() && j < d2.length();i++, j++) {
                    if(d1.charAt(i) > d2.charAt(i)){
                        return 1;
                    }
                    else if(d1.charAt(i) < d2.charAt(i)){
                        return -1;
                    }
                    else{
                        continue;
                    }
                }
                if(d1.length() > d2.length() && d2.charAt(0) >= d1.charAt(d2.length())) {
                    return 1;
                }else {
                    return -1;
                }
            }
        });
        StringBuilder ans = new StringBuilder();
        for (String s : num) {
            ans.append(s);
        }
        return String.valueOf(ans);

    }
    public static void main(String[] args) {
        int[] ar = {3,30,34,5,9};
        System.out.println(largestNumber(ar));
    }
}