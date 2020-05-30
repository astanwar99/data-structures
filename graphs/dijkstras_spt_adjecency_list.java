import java.util.*;

class Node{
    int vertex; // Vertex Number
    int value;  // Represents either distnce or wieght

    Node(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }
}

class Graph{
    private int V;
    ArrayList<Node>[] adjList;

    Graph(int V){
        this.V = V;
        adjList = new ArrayList[this.V];
    }

    void generateGraph(){
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        adjList[0].add(new Node(1, 4));
        adjList[0].add(new Node(7, 8));

        adjList[1].add(new Node(2, 8));
        adjList[1].add(new Node(7, 11));

        adjList[2].add(new Node(1, 8));
        adjList[2].add(new Node(8, 2));
        adjList[2].add(new Node(3, 7));
        adjList[2].add(new Node(5, 4));

        adjList[3].add(new Node(2, 7));
        adjList[3].add(new Node(5, 14));
        adjList[3].add(new Node(4, 9));

        adjList[4].add(new Node(3, 9));
        adjList[4].add(new Node(5, 10));
        
        adjList[5].add(new Node(2, 4));
        adjList[5].add(new Node(3, 14));
        adjList[5].add(new Node(4, 10));

        adjList[6].add(new Node(7, 1));
        adjList[6].add(new Node(8, 6));
        adjList[6].add(new Node(5, 2));

        adjList[7].add(new Node(0, 8));
        adjList[7].add(new Node(1, 11));
        adjList[7].add(new Node(8, 7));

        adjList[8].add(new Node(7, 7));
        adjList[8].add(new Node(6, 6));
        adjList[8].add(new Node(2, 2));
    }

    void printGraph() {
        for (int i = 0; i < 9; i++) {
            System.out.print(i + " -> ");
            for (Node node : adjList[i]) {
                System.out.print(node.vertex + "-" + node.value + " ");
            }
            System.out.println();
        }
    }
}

public class dijkstras_spt_adjecency_list{
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.generateGraph();
        g.printGraph();
    }
}