import static java.lang.System.*;
import java.util.*;

class mergesort{

	static void merge(int b[],int c[],int a[])
	{
		int i=0,j=0,k=0;
		while(i<b.length && j<c.length){
			if(b[i] <= c[j]){
				a[k] = b[i];
				i++;
			}
 			else{
				a[k] = c[j];
				j++;
			}
			k++;
		}
	

	 		while(i<b.length)
			{
				a[k++] = b[i++];
			}
	
			while(j<c.length)
			{
				a[k++] = c[j++];
			}

			
	}
	
	static void merge_sort(int a[],int n){
		int k = 0;
		int b[] = new int[n/2];
		int c[] = new int[(n-(n/2))];
		if(n>1){
			for(int i=0;i<n/2;i++)
			{
			    b[i] = a[i];
			}

			for(int i=n/2;i<n;i++)
			{
			     c[k++] = a[i];
			}
		
		merge_sort(b,b.length);
		merge_sort(c,c.length);
		merge(b,c,a);
		
		}
	}

	static void display(int arr[]){
		for(int i=0;i<arr.length;i++)
		{
			out.println(arr[i]);	
		}
	}


	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		out.println("Enter the number of elements in the array");
		int n = sc.nextInt();
		Random r = new Random();
		
		int []arr = new int[n];
		
		for(int i=0;i<n;i++){
			arr[i] = r.nextInt(n);
		}
		out.println("Array before sorting ::");
		display(arr);
		double st = nanoTime();
		merge_sort(arr,n);
		double ft = nanoTime();
		out.println("Array after sorting ::");
		display(arr);
		out.println("Time taken = "+ (ft-st));

	}
}


