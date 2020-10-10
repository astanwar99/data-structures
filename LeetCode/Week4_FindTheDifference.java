import java.util.*;

class Main{
    public static char findTheDifference(String s, String t) {
        int a = 0;
        for(char x : s.toCharArray()){
            a = a ^ (int)x;
        }
        for(char x : t.toCharArray()){
            a = a ^ (int)x;
        }
        return (char)a;
    }
    public static void main(String[] args) {
        String a = "abcdef";
        String b = "abcdefg";
        System.out.println(findTheDifference(a, b));
    }
}