import java.util.*;
import java.lang.*; 
import java.io.*;

public class KruskalsMST{

    int find(int i,int parent[]) 
    { 
        while (parent[i] != i) 
            i = parent[i]; 
        return i; 
    } 
  

    void union1(int i, int j,int parent[]) 
    { 
        int a = find(i,parent); 
        int b = find(j,parent); 
        parent[a] = b; 
    } 


    void createMST(int graph[][],int n) 
    { 
        int mincost = 0;  
        int[] parent = new int[n];
    
         
        for (int i = 0; i < n; i++) 
            parent[i] = i; 
    
         
        int edge_count = 0; 
        while (edge_count < n - 1) 
        { 
            int min = Integer.MAX_VALUE, a = -1, b = -1; 
            for (int i = 0; i < n; i++) 
            { 
                for (int j = 0; j < n; j++)  
                { 
                    if (find(i,parent) != find(j,parent) && graph[i][j] < min)  
                    { 
                        min = graph[i][j]; 
                        a = i; 
                        b = j; 
                    } 
                } 
            } 
    
            union1(a, b,parent); 
            System.out.printf("Edge %d:(%d, %d) cost:%d \n", 
                edge_count++, a, b, min); 
            mincost += min; 
        } 
        System.out.printf("\n Minimum cost= %d \n", mincost); 
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
                graph[i][j] = Integer.MAX_VALUE;

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
        
        KruskalsMST obj = new KruskalsMST(); 
        obj.createMST(graph, n); 

    }
}