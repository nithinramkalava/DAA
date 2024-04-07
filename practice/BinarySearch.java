package practice;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] array, int low, int high, int key) {
        int mid = low + (high - low) / 2;

        if (array[mid] == key)
            return mid;

        else if (array[mid] < key)
            return binarySearch(array, mid + 1, high, key);
        
        else if (array[mid] > key)
            return binarySearch(array, low, mid, key);

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Array must be sorted order");
        int[] array = new ArrayInput().read();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key element to search for: ");
        int key = sc.nextInt();
        sc.close();
        int result = binarySearch(array, 0, array.length - 1, key);
        System.out.println("Key Index position: " + result);
    }
}
