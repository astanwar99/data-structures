import java.util.*;

public class FEMA2_IronMagnetandWall {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t-- > 0) {
            int n = 9;
            int k = 10;
            s.nextLine();
            String inp = "MIM_XII:M";
            String[] str = inp.split("X");
            int count = 0;

            for(String tempSeq: str) {
                StringBuilder seq = new StringBuilder(tempSeq);
                // System.out.println(seq);
                int f = 0, l = 0;
                int len = seq.length();
                int score = 0;
                
                while(f < len && l < len) {
                    // M - I
                    if(seq.charAt(f) == 'M') {
                        if(seq.charAt(l) == 'I') {
                            int sh = 0;
                            if(f > l){
                                for (int i = l + 1; i < f; i++) {
                                    if(seq.charAt(i) == ':'){
                                        sh++;
                                    }
                                }
                            }else{
                                for (int i = f + 1; i < l; i++) {
                                    if(seq.charAt(i) == ':'){
                                        sh++;
                                    }
                                }
                            }
                            
                            System.out.println(sh);
                            score = k + 1 - Math.abs(f - l) - sh;
                            if(score > 0) {
                                count++;
                                f++;
                                l++;
                            }
                            else if(f > l) {
                                l++;
                            }
                            else{
                                f++;
                            }
                        }
                        // else if(seq.charAt(l) == 'X') {
                            
                        // }
                        else{
                            l++;
                        }
                    }
                    else{
                        f++;
                    }
                    // }else if(seq.charAt(f) == 'I' && seq.charAt(l) == 'M') {
                        
                    // }else if(seq.charAt(f) == 'I' && seq.charAt(l) == 'I') {
                        
                    // }else if(seq.charAt(f) == 'M' && seq.charAt(l) == 'M') {
                        
                    // }
                }



                // // System.out.println(seq);
                // ArrayList<Integer> Mindex = new ArrayList<>();
                // ArrayList<Integer> Iindex = new ArrayList<>();
                // // ArrayList<Integer> Sindex = new ArrayList<>();
                
                // for (int i = 0; i < seq.length(); i++) {
                //     if(seq.charAt(i) == 'M') {
                //         Mindex.add(i);
                //     }
                //     else if(seq.charAt(i) == 'I') {
                //         Iindex.add(i);
                //     }
                // }
                // // System.out.println(Mindex + " " + Iindex);

                // for (int i = 0; i < Mindex.size(); i++) {
                //     ListIterator<Integer> iter = Iindex.listIterator();
                //     while(iter.hasNext()) {
                //         int j = iter.next();
                //         int power = k + 1 - Math.abs(i - j);
                //         if(power > 0) {
                //             count++;
                //             iter.remove();
                //             break;
                //         }
                //     }
                // }
                
            }
            System.out.println(count);
        }
    }
}
