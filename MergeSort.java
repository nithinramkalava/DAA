import java.util.Arrays;

public class MergeSort {

  void merge(int arr[], int start, int mid, int stop) {
    int sort[] = new int[stop - start + 1];

    int n1 = mid + 1;
    int n2 = stop + 1;

    int i = start, j = mid + 1, k = 0;

    while (i < n1 && j < n2) {
      if (arr[i] < arr[j]) {
        sort[k] = arr[i];
        i++;
      } else {
        sort[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      sort[k] = arr[i];
      k++;
      i++;
    }

    while (j < n2) {
      sort[k] = arr[j];
      k++;
      j++;
    }

    for (k = 0, i = start; i < stop + 1; i++, k++) {
      arr[i] = sort[k];
    }
  }

  void mergeSort(int arr[], int start, int stop) {
    if (!(start < stop)) return;

    int mid = (start + stop) / 2;

    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, stop);
    merge(arr, start, mid, stop);
  }

  public static void main(String args[]) {
    int arr[] = { 6, 5, 12, 10, 9, 1 };
    // int arr[] = new ArrayInput().read();

    MergeSort ob = new MergeSort();
    ob.mergeSort(arr, 0, arr.length - 1);

    System.out.println("Sorted array:");
    System.out.println(Arrays.toString(arr));
  }
}
