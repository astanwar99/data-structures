import java.util.*;

public class PathThroughGraph{

    public static void factorization(Map<Integer, Integer> hm, int num) 
    { 
        hm.put(1, 1);
        if(num % 2 == 0){
            hm.put(2, 0);
        } 
        while(num % 2 == 0) 
        { 
            hm.put(2, hm.get(2) + 1);
            num /= 2; 
        } 

        for (int i = 3; i <= Math.sqrt(num); i+= 2) 
        { 
            if(num % i == 0){
                hm.put(i, 0);
            }
            while (num % i == 0) 
            { 
                hm.put(i, hm.get(i) + 1); 
                num /= i; 
            } 
        } 

        if (num > 2){
            hm.put(num, 1); 
        }
    } 

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        Map<Integer, Integer> ah = new TreeMap<>();
        Map<Integer, Integer> bh = new TreeMap<>();
        factorization(ah, a);
        factorization(bh, b);
        
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();

        int afact = a;
        for (Map.Entry<Integer, Integer> e : ah.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            while(val-- > 0) {
                afact /= key;
                al.add(afact);
            }
        }

        int bfact = b;
        for (Map.Entry<Integer, Integer> e : bh.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            while(val-- > 0) {
                bfact /= key;
                bl.add(bfact);
            }
        }

        int ac = 0;
        int bc = 0;

        while(al.get(ac) != bl.get(bc) && ac < al.size() && bc < bl.size()) {
            while(al.get(ac) > bl.get(bc)) {
                ac++;
            }
            while(al.get(ac) < bl.get(bc)) {
                bc++;
            }
        }
        System.out.println(ac + bc);
    }
}

