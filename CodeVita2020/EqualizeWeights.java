import java.util.*;

public class EqualizeWeights{

    public static void getSequences(ArrayList<ArrayList<Integer>> Ans, ArrayList<Integer> allWeights, ArrayList<Integer> temp,  
    boolean[] dp, int sum, int start) 
    { 
        if(start > allWeights.size() || sum < 0) 
            return ; 
   
        if(sum == 0) 
        { 
            Ans.add(new ArrayList<Integer>(temp));
            for(Integer num: temp) {
                dp[allWeights.indexOf(num)] = true;
            }
            return; 
        } 
        else { 
            for (int i = start; i < allWeights.size(); i++) {
                if(dp[i]){
                    continue;
                }
                temp.add(allWeights.get(i));
                getSequences(Ans, allWeights, temp, dp, sum - allWeights.get(i), i+1); 
                temp.remove(temp.size() - 1);
            } 
        } 
    }

    public static ArrayList<Integer> getSequences2(ArrayList<Integer> allWeights, ArrayList<Integer> temp, boolean[] dp, 
        int sum, int start, int count, int l) 
    { 
        if(start > allWeights.size() || sum < 0) 
            return null; 
   
        if(sum == 0) 
        { 
            for(Integer num: temp) {
                dp[allWeights.indexOf(num)] = true;
            }
            return temp;
            // Ans.add(new ArrayList<Integer>(temp));
            
            // return; 
        } 
        else { 
            for (int i = start; i < allWeights.size(); i++) {
                if(dp[i] || l == count){
                    continue;
                }
                temp.add(allWeights.get(i));
                count++;
                ArrayList<Integer> x = getSequences2(allWeights, temp, dp, sum - allWeights.get(i), i+1, count, l); 
                if(x != null){
                    return x;
                }
                temp.remove(temp.size() - 1);
                count--;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nLen = new int[n];
        int sum = 0;

        // ArrayList<ArrayList<Integer>> weights = new ArrayList<>();
        ArrayList<Integer> allWeights = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            nLen[i] = s.nextInt();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < nLen[i]; j++) {
                int t = s.nextInt();
                // temp.add(t);
                allWeights.add(t);
                sum += t;
            }
            // weights.add(temp);
        }
        sum /= n;
        Collections.sort(allWeights);
        ArrayList<ArrayList<Integer>> Ans = new ArrayList<ArrayList<Integer>>();
        boolean[] dp = new boolean[allWeights.size()];
        // getSequences(Ans, allWeights, new ArrayList<Integer>(), dp, sum, 0);
        
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> ans = getSequences2(allWeights, new ArrayList<Integer>(), dp, sum, 0, 0, nLen[i]);
            Ans.add(ans);
        }
        // System.out.println(Ans);
        Collections.sort(Ans, new Comparator<List<Integer>> () {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });
        for(ArrayList<Integer> a1: Ans) {

            for(Integer x: a1) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}