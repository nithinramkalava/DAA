import java.util.Scanner;

public class BinarySearch {

  int binarySearch(int array[], int x, int low, int high) {
    if (high >= low) {
      int mid = (high + low) / 2;

      if (array[mid] == x) return mid;

      if (array[mid] > x) return binarySearch(array, x, low, mid - 1);

      return binarySearch(array, x, mid + 1, high);
    }

    return -1;
  }

  int binarySearchIterative(int array[], int x, int low, int high) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == x) return mid;

      if (array[mid] < x) low = mid + 1; else high = mid - 1;
    }

    return -1;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    BinarySearch ob = new BinarySearch();
    // int array[] = { 3, 4, 5, 6, 7, 8, 9 };
    int array[] = new ArrayInput().read();
    int n = array.length;
    int x = sc.nextInt();
    sc.nextLine();
    sc.close();
    int result = ob.binarySearch(array, x, 0, n - 1);
    if (result == -1) System.out.println("Not found"); else System.out.println(
      "Element found at index " + result
    );
  }
}
