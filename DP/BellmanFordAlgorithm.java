import java.util.*;


class Graph{
    class Edge{
        int source;
        int dest;
        int weight;
        Edge(){
            source = dest = weight = 0;
        }
    }

    int V,E;
    Edge edges[];

    Graph(int V, int E){
        this.V = V;
        this.E = E;
        edges = new Edge[E];

        for(int edge = 0 ; edge<E ; edge++){
            edges[edge] = new Edge();
        }
    }
}


public class BellmanFordAlgorithm {

    static void displayResult(int dist[],int parent[],int V){
        System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < V; i++) 
        System.out.println(i + "\t\t" + dist[i]);
        
        System.out.println("Minimum weight path from source to vertex");
        for(int i = 0 ; i < V-1; i++){
            System.out.print(parent[i] + "-->");
        }
        System.out.print(parent[V-1]);
    }

    static void calculateMinimumDistance(Graph graph,int src){
        int V = graph.V;
        int E = graph.E;
        int dist[] = new int[V];
        int parent[] = new int[V];
        dist[0] = 0;
        parent[0] = 0;
        for(int i = 1; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        for(int i = 1 ; i < V ; i++ ){
            for(int j = 0; j < E ; j++){
                int source = graph.edges[j].source;
                int dest = graph.edges[j].dest;
                int weight = graph.edges[j].weight;

                if((dist[source] != Integer.MAX_VALUE) && (dist[source] + weight < dist[dest])){
                    parent[dest] = source;
                    dist[dest] = dist[source] + weight;
                }
            }
        }

        //Check for negative cycles ::
        for(int j = 0; j < E ; j++){
            int source = graph.edges[j].source;
            int dest = graph.edges[j].dest;
            int weight = graph.edges[j].weight;

            if(dist[source] != Integer.MAX_VALUE && dist[source] + weight < dist[dest]){
                System.out.println("Graph contains negative weight cycle ");
                return;
            }
        }

        displayResult(dist,parent,V);
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many vertices in the graph?");
        int V = sc.nextInt();
        System.out.println("How many edges in the graph?");
        int E = sc.nextInt();

        Graph graph = new Graph(V,E);

        for(int i = 0;i<E;i++){
            System.out.println("Enter the triple (source,destination,weight) for the edge " + (i+1) + " :: ");
            graph.edges[i].source = sc.nextInt();
            graph.edges[i].dest = sc.nextInt();
            graph.edges[i].weight = sc.nextInt();
        }

        calculateMinimumDistance(graph,0);
    }
}