package practice;

import java.util.Arrays;
import java.util.Scanner;

class Job {
    String id;
    int deadline;
    double profit;
    public Job(String id, String deadline, String profit) {
        this.id = id;
        this.deadline = Integer.parseInt(deadline);
        this.profit = Double.parseDouble(profit);
    }
}

public class JobSequencing {
    public static void printJobSequence(Job[] jobSequence){
        System.out.print("Job Sequence for maximum profit: ");
        for (Job job : jobSequence) {
            if (job != null) System.out.print(job.id + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input;

        System.out.print("Enter number of jobs: ");
        int num_jobs = sc.nextInt(), max_dealine = 0;
        Job[] jobs = new Job[num_jobs];
        sc.nextLine();
        for (int i = 0; i < num_jobs; i++) {
            System.out.println("Enter jod id, deadline and profit seperated by space: ");
            input = sc.nextLine().split(" ");
            if (max_dealine < Integer.parseInt(input[1])) max_dealine = Integer.parseInt(input[1]);
            jobs[i] = new Job(input[0], input[1], input[2]);
        }
        sc.close();
        Arrays.sort(jobs, (a , b) -> Double.compare(b.profit, a.profit));

        Job[] jobSequence = new Job[max_dealine];

        Arrays.fill(jobSequence, null);

        for (Job job : jobs) {
            if(jobSequence[job.deadline - 1] == null) 
                jobSequence[job.deadline - 1] = job;
            else {
                for(int i = job.deadline - 2; i > -1; i--)
                    if (jobSequence[i] == null) 
                        jobSequence[i] = job;
            }
        }

        printJobSequence(jobSequence);
    }
}
