import java.util.*;

public class maximum_occuring_character_in_string{
    public static void main(String[] args) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        String str = "Happy Ccccoding";
        char max_char = 'a';
        int max = -1;

        for(int i = 0; i < str.length(); i++) {
            if(hmap.get(str.charAt(i)) == null){
                hmap.put(str.charAt(i), 1);
            }
            int val = hmap.get(str.charAt(i)) + 1;
            hmap.put(str.charAt(i), val);
            if(max < val) {
                max = val;
                max_char = str.charAt(i);
            }
        }

        System.out.println(max_char);
    }
}