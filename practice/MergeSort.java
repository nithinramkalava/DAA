package practice;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] array, int low, int mid, int high){
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        while( i < mid + 1 && j < high + 1) {
            if(array[i] < array[j]){
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < mid + 1){
            temp[k]  = array[i];
            i++; k++;
        }

        while (j < high + 1){
            temp[k]  = array[j];
            j++; k++;
        }

        for(i = low, k = 0; i < high + 1; i++, k++){
            array[i] = temp[k];
        }
    }

    public static void mergeSort(int[] array, int low, int high){
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        int[] array = new ArrayInput().read();
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
