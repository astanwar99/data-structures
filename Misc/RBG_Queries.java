import java.util.*;

class Color implements Comparable<Color>{
    int R, B, G;

    Color(int r, int b,int g) {
        R = r;
        B = b;
        G = g;
    }

    @Override
    public boolean equals(Object a) {
        Color other = (Color)a;
        if(this.R == other.R && this.B == other.B && this.G == other.G)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + R;
        result = prime * result + B;
        result = prime * result + G;
        return result;
    }

    @Override
    public int compareTo(Color o) {
        return (int)(this.R - o.R);
    }

    @Override
    public String toString() {
        return R + "-" + B + "-" + G;
    }
}

class Main{

    static String possible(Color[] colors, Color query, int n) {
        // Set<Color> setR = new HashSet<>();
        // Set<Color> setB = new HashSet<>();
        // Set<Color> setG = new HashSet<>();

        int i = 0;
        int mr = -1, mb = -1, mg = -1;
        Color nColor = new Color(mr, mb, mg);
        
        while (i < n && colors[i].R <= query.R) {
        
            if(colors[i].B <= query.B && colors[i].G <= query.G) {
                // setR.add(colors[i]);
                if(colors[i].R > nColor.R) {
                    nColor.R = colors[i].R;
                }
                if(colors[i].B > nColor.B) {
                    nColor.B = colors[i].B;
                }
                if(colors[i].G > nColor.G) {
                    nColor.G = colors[i].G;
                }
            
                if(nColor.equals(query))
                    return "YES";
            }
            i++;

            // if(colors[i].B <= query.B) {
            //     setB.add(colors[i]);
            // }

            // if(colors[i].G <= query.G) {
            //     setG.add(colors[i]);
            // }
        }

        return "NO";

    }

        // setR.retainAll(setB);
        // setR.retainAll(setG);

        // System.out.println(setR);

    //     if(setR.isEmpty()) {
    //         return "NO";
    //     }
    //     else{
    //         int mr = -1, mb = -1, mg = -1;
    //         for(Color c: setR) {
    //             if(c.R > mr) {
    //                 mr = c.R;
    //             }
    //             if(c.B > mb) {
    //                 mb = c.B;
    //             }
    //             if(c.G > mg) {
    //                 mg = c.G;
    //             }
    //         }
            
    //         Color nColor = new Color(mr, mb, mg);
            
    //         if(nColor.equals(query))
    //             return "YES";
    //         else
    //             return "NO";
    //     }
    // }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, q;
        n = s.nextInt();
        q = s.nextInt();
        Color[] colors = new Color[n];
        // Color[] queries = new Color[n];

        for (int i = 0; i < n; i++) {
            int r = s.nextInt();
            int b = s.nextInt();
            int g = s.nextInt();
            colors[i] = new Color(r, b, g);
        }

        Arrays.sort(colors);

        for (int i = 0; i < q; i++) {
            int r = s.nextInt();
            int b = s.nextInt();
            int g = s.nextInt();
            Color query = new Color(r, b, g);

            System.out.println(possible(colors, query, n));
            
        }
    }

    public static List<String> mixColors(List<List<Integer>> col, List<List<Integer>> que) {
        // Write your code here
        int n, q;
        n = col.size();
        q = que.size();

        List<String> ans = new ArrayList<>();

        Color[] colors = new Color[n];
        // Color[] queries = new Color[n];

        for (int i = 0; i < n; i++) {
            int r = col.get(i).get(0);
            int b = col.get(i).get(1);
            int g = col.get(i).get(2);
            colors[i] = new Color(r, b, g);
        }

        Arrays.sort(colors);

        for (int i = 0; i < q; i++) {
            int r = que.get(i).get(0);
            int b = que.get(i).get(1);
            int g = que.get(i).get(2);
            Color query = new Color(r, b, g);

            ans.add(possible(colors, query, n));
            
        }
        return ans;
    }

}