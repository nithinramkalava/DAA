import java.util.Scanner;

public class ArrayInput {

  public int[] read() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter array elements separated by space: ");
    String[] strArray = sc.nextLine().split(" ");
    sc.close();
    int[] intArray = new int[strArray.length];
    for (int i = 0; i < strArray.length; i++) {
      intArray[i] = Integer.parseInt(strArray[i]);
    }
    return intArray;
  }
}
