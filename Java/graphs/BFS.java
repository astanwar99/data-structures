import java.util.*;

class Node{
    int value;
    Node left, right;
    Node(){
        value = 0;
        left = right = null;
    }
    Node(int v){
        value = v;
        left = right = null;
    }
}

class Graph {
    int V;
    ArrayList<Integer>[] adjList;
    Graph() {
        V = 1;
        adjList = new ArrayList[this.V];
        adjList[0] = new ArrayList<>();
    }

    Graph(int v, List<Integer> from, List<Integer> to) {
        V = v;
        adjList = new ArrayList[this.V];
        for (int i = 0; i < this.V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < from.size(); i++) {
            adjList[from.get(i) - 1].add(to.get(i) - 1);
        }
    }

    ArrayList<Integer> bfs() {
        boolean[] visited = new boolean[this.V];
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        Q.add(0);
        while(!Q.isEmpty()) {
            Integer curr = Q.poll();
            bfs.add(curr);
            for (Integer to : adjList[curr]) {
                if(!visited[to]){
                    Q.add(to);
                    visited[to] = true;
                }
            }
        }
        return bfs;
    }
    
}

public class BFS {
    public static void main(String[] args) {
        ArrayList<Integer> from = new ArrayList<>(
            Arrays.asList(1, 1, 1, 2, 3)
        );
        ArrayList<Integer> to = new ArrayList<>(
            Arrays.asList(2, 3, 4, 3, 4)
        );
        Graph g = new Graph(4, from, to);
        System.out.println(g.bfs());
    }
}