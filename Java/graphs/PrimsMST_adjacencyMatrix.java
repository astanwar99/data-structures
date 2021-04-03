YYYYYYYYYYYYYYYYYYY/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

class Graph{
    int V;
    int[][] adjMat;
    
    Graph(int V, int[][] adjMat) {
        this.V = V;
        this.adjMat = adjMat;
    }
    
    void mst_prims() {
        // Set<Integer> mstSet = new HashSet<>();
        List<Integer> mstSet = new ArrayList<>();
        int[] key = new int[this.V];
        
        for(int i = 1; i < this.V; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        
        key[0] = 0;
        for(int i = 0; i < V; i++) {
            int v = minVertex(mstSet, key);
            // System.out.println("Current v: " + v);
            for(int j = 0; j < this.V; j++) {
                // System.out.println(adjMat[v][j]);
                if(adjMat[v][j] != 0 && key[j] > adjMat[v][j]) {
                    key[j] = adjMat[v][j];    
                    // System.out.println("key: " + key[j]);
                }
            }
            mstSet.add(v); 
            System.out.println(" - " + v);
        }
        
        for(Integer v : mstSet) {
            System.out.println(v);
        }
        
    }
    
    int minVertex(List<Integer> mstSet, int[] key) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < this.V; i++) {
            if(!mstSet.contains(i) && key[i] < min){
                min = key[i];
                index = i;
            }
        }
        return index;
    }
    
}

public class Main
{
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        
        Graph G = new Graph(9, graph);
        G.mst_prims();
        // int[] dist = G.dijkstra(7);
        // for (int i = 0; i < dist.length; i++) {
        //     System.out.println(dist[i]);
        // }
	}
}
