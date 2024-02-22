package practice;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] array, int low, int high){
        int pivot = array[high];

        int i = low - 1;

        for (int j = 0; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        array[high] = array[i];
        array[i] = pivot;

        return i;
    }

    public static void quickSort(int[] array, int low, int high){
        if (low >= high) return;
        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }
    public static void main(String[] args) {
        int[] array = new ArrayInput().read();
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
