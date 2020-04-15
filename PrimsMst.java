import java.util.*;
import java.lang.*; 
import java.io.*;

public class PrimsMst{

    int minVertex(int nodeList[], Boolean isIncluded[],int n) 
    {  
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < n; v++) 
            if (isIncluded[v] == false && nodeList[v] <= min) { 
                min = nodeList[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 


    void display(int prevNode[], int graph[][] , int n) 
    { 
        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < n; i++) 
            System.out.println(prevNode[i] + " - " + i + "\t" + graph[i][prevNode[i]]);
    }


    void createMST(int graph[][], int n) 
    { 
        int nodeList[] = new int[n];  
        int prevNode[] = new int[n];  
   
        Boolean isIncluded[] = new Boolean[n]; 
   
        for (int i = 0; i < n; i++) { 
            nodeList[i] = Integer.MAX_VALUE; 
            isIncluded[i] = false; 
        } 
   
        nodeList[0] = 0; 
        prevNode[0] = -1; 
   
        for (int count = 0; count < n - 1; count++) { 
             
            int u = minVertex(nodeList, isIncluded,n); 
  
            isIncluded[u] = true; 
   
            for (int v = 0; v < n; v++) 

                if (!isIncluded[v] && graph[u][v] != 0 &&  
                   nodeList[u] != Integer.MAX_VALUE && graph[u][v] < nodeList[v]) {
                    nodeList[v] = graph[u][v]; 
                    prevNode[v] = u;
                   }
        } 
            
        display(prevNode, graph, n); 
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
            graph[v][u] = w;
        }
        
        PrimsMst obj = new PrimsMst(); 
        obj.createMST(graph, n); 

    }
}