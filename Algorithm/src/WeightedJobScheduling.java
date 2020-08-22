import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {
	public static void main(String args[]) {
		Job[] jobs = {new Job(0,6,60), new Job(1,4,30), new Job(3,5,10), 
				new Job(5,7,30), new Job(5,9,150), new Job(7,8,100) };
		Arrays.sort(jobs, new SortJob());
		System.out.print(new WeightedJobScheduling().getMaxProfit(jobs, 0));
	}
	int profit[] = new int[10];
	private int getMaxProfit(Job[] jobs, int from) {
		if(from >= jobs.length) {
			return 0;
		}
		if(profit[from] != 0) {
			return profit[from];
		}
		int sol = Math.max(
				jobs[from].profit + getMaxProfit(jobs, getNextNonOverlappingJob(jobs, from)), 
				getMaxProfit(jobs, from+1));
		System.out.println("Profit: " + jobs + " from: "+(from+1) + ", Sol=" + sol);
		profit[from] = sol;
		return sol;
	}

	private int getNextNonOverlappingJob(Job[] jobs, int from) {
		for(int i=from+1; i<jobs.length; i++) {
			if(jobs[i].start >= jobs[from].end) {
				return i;
			}
		}
		return 99999;
	}
}

class Job{
	int start;
	int end;
	int profit;
	public Job(int start, int end, int profit) {
		super();
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}
class SortJob implements Comparator<Job> 
{ 
    public int compare(Job a, Job b) 
    { 
        return a.start - b.start; 
    } 
} 
