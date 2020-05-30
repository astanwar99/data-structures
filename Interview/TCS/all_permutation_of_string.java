public class all_permutation_of_string {
    void permute(String str, int l, int r) {
        if(l == r){
            System.out.println(str);
        }else{
            for(int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    String swap(String str, int l, int r) {
        char[] ch = str.toCharArray();
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
        return new String(ch); 
    }

    public static void main(String[] args) {
        String str = "abc";
        all_permutation_of_string a = new all_permutation_of_string();
        a.permute(str, 0, str.length() - 1);
    }
}