import java.util.*;

public class anagram{
    public static void main(String[] args) {
        String s1 = "ates";
        String s2 = "ebst";

        HashMap<Character, Integer> hs1 = new HashMap<>();
        HashMap<Character, Integer> hs2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            if(hs1.get(s1.charAt(i)) == null){
                hs1.put(s1.charAt(i), 1);
            }
            int val = hs1.get(s1.charAt(i)) + 1;
            hs1.put(s1.charAt(i), val);
        }

        for(int i = 0; i < s2.length(); i++) {
            if(hs2.get(s2.charAt(i)) == null){
                hs2.put(s2.charAt(i), 1);
            }
            int val = hs2.get(s2.charAt(i)) + 1;
            hs2.put(s2.charAt(i), val);
        }

        boolean flag = true;

        for(int i = 0; i < s1.length(); i++) {
            if(s1.length() != s2.length()){
                flag = false;
                break;
            }
            if(hs1.get(s1.charAt(i)) == hs2.get(s1.charAt(i))){
                continue;
            }else{
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("Anagram");
        }else{
            System.out.println("Not an Anagram");
        }

    }
}