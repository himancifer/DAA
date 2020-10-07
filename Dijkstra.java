import java.util.*;
import java.lang.*; 
import java.io.*;

public class Dijkstra{

    
    int minDistance(int shortestDist[], Boolean isIncluded[],int n) 
    {  
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < n; v++) 
            if (isIncluded[v] == false && shortestDist[v] <= min) { 
                min = shortestDist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 


    void display(int shortestDist[], int n) 
    { 
        System.out.println("Source to Vertex = Shortest Distance"); 
        for (int i = 0; i < n; i++) 
            System.out.println(0 + " to " + i + " = " + shortestDist[i]); 
    }


    void dijkstra(int graph[][], int source, int n) 
    { 
        int shortestDist[] = new int[n];  
   
        Boolean isIncluded[] = new Boolean[n]; 
   
        for (int i = 0; i < n; i++) { 
            shortestDist[i] = Integer.MAX_VALUE; 
            isIncluded[i] = false; 
        } 
   
        shortestDist[source] = 0; 
   
        for (int count = 0; count < n - 1; count++) { 
             
            int u = minDistance(shortestDist, isIncluded,n); 
  
            isIncluded[u] = true; 
   
            for (int v = 0; v < n; v++) 

                if (!isIncluded[v] && graph[u][v] != 0 &&  
                   shortestDist[u] != Integer.MAX_VALUE && shortestDist[u] + graph[u][v] < shortestDist[v]) 
                    shortestDist[v] = shortestDist[u] + graph[u][v]; 
        } 
            
        display(shortestDist, n); 
    } 

    public static void main(String[] args) 
    { 
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of vertices :: ");
        int n = sc.nextInt();
        System.out.println("Enter the total number of edges :: ");
        int edges = sc.nextInt();

        int graph[][] = new int[n][n]; 


        for(int i = 0 ; i<n; i++)
            for(int j=0; j<n ; j++)
                graph[i][j] = 0;

        System.out.println("Enter the vertices and their weight (u,v,w) :: ");
        for(int i=0;i<edges;i++)
        {
            System.out.println(i + " triple ::");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
        }
        
        Dijkstra obj = new Dijkstra(); 
        obj.dijkstra(graph, 0, n); 

    }
}
