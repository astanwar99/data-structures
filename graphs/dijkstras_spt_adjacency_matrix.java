

import java.util.*;

class Graph{
    int V;
    int[][] adjMat;

    Graph(int V, int[][] adjMat) {
        this.V = V;
        this.adjMat = adjMat;
    }

    int minDistanceFromV(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, u = -1;

        for (int i = 0; i < this.V; i++) {
            if(!visited[i] && distance[i] <= min){
                u = i;
                min = distance[i];
            }
        }
        return u;
    }

    int[] dijkstra(int src) {
        boolean[] visited = new boolean[this.V];
        int[] distance = new int[this.V];
        for (int i = 0; i < this.V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;
        for (int i = 0; i < this.V - 1; i++) {
            int u = minDistanceFromV(distance, visited);
            visited[u] = true;

            for (int v = 0; v < this.V; v++) {
                if(!visited[v] && this.adjMat[u][v] != 0 && distance[u] != Integer.MAX_VALUE 
                && distance[u] + this.adjMat[u][v] < distance[v]){
                    distance[v] = distance[u] + this.adjMat[u][v];
                }
            }
        }
        return distance;
    }

    void display() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class dijkstras_spt_adjacency_matrix{
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
        int[] dist = G.dijkstra(7);
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]);
        }

        String a = "hello";
    }
}