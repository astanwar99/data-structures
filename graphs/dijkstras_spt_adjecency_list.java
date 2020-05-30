import java.util.*;

class Node implements Comparable<Node>{
    int vertex; // Vertex Number
    int value;  // Represents either distnce or wieght

    Node(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Node n) {
        if(n.vertex == vertex && n.value == value){
            return 0;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) { 
  
        // If the object is compared with itself then return true   
        if (o == this) { 
            return true; 
        } 
  
        /* Check if o is an instance of Complex or not 
          "null instanceof [type]" also returns false */
        if (!(o instanceof Node)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        Node n = (Node) o; 
          
        // Compare the data members and return accordingly  
        if(n.vertex == vertex && n.value == value){
            return true;
        }
        return false; 
    }
}

class Graph{
    int V;
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
        adjList[7].add(new Node(6, 1));

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

    Node isInHeapAndWhatValue(Node vertex, PriorityQueue<Node> heap) {
        for (Node node : heap) {
            if(node.vertex == vertex.vertex){
                return new Node(1, node.value);
            }
        }
        return new Node(0, 0);
    }

    ArrayList<Node> dijkstraAlgo(Graph g){
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.value - b.value;
            }
        });

        ArrayList<Node> stp = new ArrayList<>();

        // Initialize min Heap
        minHeap.add(new Node(0, 0));
        for (int i = 1; i < g.V; i++) {
            minHeap.add(new Node(i, Integer.MAX_VALUE));
        }

        while(!minHeap.isEmpty()) {
            Node currVertex = minHeap.poll();
            
            // Traverse adjacent vertex
            for (Node adjVertex : g.adjList[currVertex.vertex]) {
                Node infoOfVertexInHeap = isInHeapAndWhatValue(adjVertex, minHeap);
                if(infoOfVertexInHeap.vertex == 1 && currVertex.value + adjVertex.value < infoOfVertexInHeap.value){
                    minHeap.remove(new Node(adjVertex.vertex, infoOfVertexInHeap.value));
                    minHeap.add(new Node(adjVertex.vertex, currVertex.value + adjVertex.value));
                }
            }
            stp.add(currVertex);
        }

        return stp;
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.generateGraph();
        // g.printGraph();

        ArrayList<Node> shortestDistances = new dijkstras_spt_adjecency_list().dijkstraAlgo(g);
        for (Node node : shortestDistances) {
            System.out.println(node.vertex + " -> " + node.value);
        }
    }
}