package practice;

import java.util.PriorityQueue;

public class OptimalMergePatterns {
    public static int merge(int[] array) {
        int cost = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(array.length);
        for(int ele : array)
            queue.offer(ele);

        while (queue.size() > 1) {
            int left = queue.poll();
            int right = queue.poll();
            int merged = left + right;
            cost += merged;
            queue.offer(merged);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] array = new ArrayInput().read();
        System.out.println("Cost: " + merge(array));
    }
}
