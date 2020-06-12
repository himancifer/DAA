import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Interval{
    int start;
    int end;
    int weight;
    Interval(int start,int end,int weight){
        this.start= start;
        this.end = end;
        this.weight= weight;
    }
}

class FinishTimeComparator implements Comparator<Interval>{
    @Override
    public int compare(Interval interval1,Interval interval2){
        return interval1.end <= interval2.end ? -1 : 1;
    }
}

public class WeightedIntervalScheduling {

    static int intervalList(Interval[] intervals){
        Arrays.sort(intervals,new FinishTimeComparator());
        int dp[] = new int[intervals.length];
        
        dp[0] = intervals[0].weight;

        for(int i = 1 ; i < intervals.length; i++){
            dp[i] = Math.max(intervals[i].weight, dp[i-1]);
            for(int j = i-1; j >=0 ; j--){
                //If the intervals are compatible
                if(intervals[j].end <= intervals[i].start){
                    //max(best after exluding,best after including)
                    dp[i] = Math.max(dp[i],intervals[i].weight + dp[j]);
                    break;
                }
            }
        }

        int maximumWeight = Integer.MIN_VALUE;
        //Find maximum weight and print the OPT array:
        System.out.println("Optimal Array");
        for(int weight : dp){
            System.out.print(weight + " ");
            maximumWeight = Math.max(maximumWeight,weight);
        }

        System.out.println();

        return maximumWeight;
    }

    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the number of intervals : ");
        int n = sc.nextInt();
        Interval intervals[] = new Interval[n];

        for(int inputs = 0 ; inputs < n; inputs++){
            System.out.println("Enter the the triple : (startInterval,endInterval,weight) for interval "+ (inputs+1) + " :: ");
            int start = sc.nextInt(); 
            int end = sc.nextInt(); 
            int weight = sc.nextInt();
            intervals[inputs] = new Interval(start, end, weight); 
        }

        System.out.println("Maximum weight : "+ intervalList(intervals));
        
    }
    
}