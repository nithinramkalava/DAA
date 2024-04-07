package practice;

import java.util.*;

public class SumOfSubsets {

    public static void findSubsets(int[] array, int targetSum, int currentSum, int index,List<Integer> subsets) {
        if(currentSum == targetSum) {
            System.out.println(subsets + " " + targetSum);
            return;
        }

        if (currentSum > targetSum || index == array.length) return;


        subsets.add(array[index]);
        currentSum += array[index];

        findSubsets(array, targetSum, currentSum, index + 1, subsets);

        subsets.remove(subsets.size() -  1);
        currentSum -= array[index];

        findSubsets(array, targetSum, currentSum, index + 1, subsets);
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 5, 18, 12, 20, 15};
        int targetSum = 35;
        
        List<Integer> subset = new ArrayList<>();
        findSubsets(arr, targetSum, 0, 0, subset);
    }
}