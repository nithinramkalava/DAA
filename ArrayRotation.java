import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new ArrayInput().read();
        System.out.println("Enter number of rotations: ");
        int rotations = sc.nextInt();
        int[] rotatedArray = rotateArray(array, rotations);
        System.out.println("Rotated array is: ");
        System.out.print(Arrays.toString(rotatedArray));
        sc.close();
    }

    static int[] rotateArray(int[] array, int rotations) {
        int[] rotatedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            rotatedArray[(i + rotations) % array.length] = array[i];
        }
        return rotatedArray;
    }
}
