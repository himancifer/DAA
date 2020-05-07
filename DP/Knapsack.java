import java.util.*;

class Knapsack{

    static int max(int a,int b){
        return a>b ? a : b;
    }
    
    static int[][] OPT(int n, int weight[], int value[],int w){
        int [][] table = new int[n+1][w+1];

        for(int row = 1; row<=n; row++){
            for(int col = 0; col<=w; col++){
                if(weight[row-1] > col)
                    table[row][col] = table[row-1][col];
                else
                    table[row][col] = max(table[row-1][col], value[row-1] + table[row-1][col-weight[row-1]]);
            }
        }

        return table;
    }


    static void displayTable(int table[][],int n,int w){
        for(int row = 0; row<=n; row++){
            for(int col = 0; col<=w; col++)
                System.out.print(table[row][col] + " ");

            System.out.println();
        }
    }

    static List<Integer> displayItems(int table[][],int weight[],int n,int w){
        List<Integer> items = new ArrayList<>();

        int row = n , col = w;
        while(row > 0 && col > 0){
            if(table[row][col] != table[row-1][col]){
                items.add(row);
                col -= weight[row-1];
            }
            row--;
        }

        return items;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items");
        int n = sc.nextInt();
        int [] value = new int[n];
        int [] weight = new int[n];
        for (int i = 0;i<n;i++){
            System.out.println("Enter the weight and corresponding value for the item "+(i+1)+" : ");
            weight[i] = sc.nextInt(); 
            value[i] = sc.nextInt();
        }

        System.out.println("Enter the weight of the knapsack");
        int w = sc.nextInt();
        int [][] table  = OPT(n,weight,value,w);

        displayTable(table,n,w);
        System.out.println("Maximum value of the items in the knapsack = "+ table[n][w]);
       
        try{
            List<Integer> items = displayItems(table,weight,n,w);
        
            ListIterator<Integer> it = items.listIterator();
            
            System.out.println("Items in the knapsack are : ");
            while(it.hasNext()){
                System.out.print(it.next()  + " ");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
         
    }
}