import java.util.*;
class Main{
    public static boolean checkSeq(int i, int j, int m, int[][] targetGrid){
        int key = targetGrid[i][0];
        Set<Integer> rep = new HashSet<>();
        rep.add(key);
        for(j = 0; j < m; j++) {
            if(targetGrid[i][j] != key) {
                if(rep.add(targetGrid[i][j])){
                    // System.out.println(targetGrid[i][j] + " " + key);
                    key = targetGrid[i][j];
                }
                else
                    return false;
            }
        }
        return true;
    }

    public static boolean isPrintable(int[][] targetGrid) {
        Map<Integer, List<Integer>> h = new HashMap<>();
        int n = targetGrid.length;
        int m = targetGrid[0].length;
        for(int i = 0; i < n; i++) {
            if(!checkSeq(i, 0, m, targetGrid)){
                return false;
            }
            for(int j = 0; j < m; j++) {
                // System.out.print(targetGrid[i][j] + " ");
                if(h.containsKey(targetGrid[i][j])) {
                    int x = h.get(targetGrid[i][j]).get(0);
                    int y = h.get(targetGrid[i][j]).get(1);
                    if(x > i || y > j) {
                        return false;
                    }
                }
                else {
                    Integer[] pos = {i, j}; 
                    h.put(Integer.valueOf(targetGrid[i][j]), Arrays.asList(pos));
                    // System.out.println(targetGrid[i][j] + "->" + pos[0] + ", " + pos[1]);
                }
            }

            // System.out.println();
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] ar = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ar[i][j] = s.nextInt();
            }
        }

        System.out.println(isPrintable(ar));
    }
}