package practice;


class Pair {
    int min, max;
}

public class MinMax {
    public static Pair minMax(int[] array, int low, int high) {

        Pair result = new Pair();

        if (low == high) {
            result.min = array[low];
            result.max = array[low];
        } else if (low + 1 == high) {
            result.min = Math.min(array[low], array[high]);
            result.max = Math.max(array[low], array[high]);
        }
        else {
            int mid = low + (high - low) / 2;

            Pair left = minMax(array, low, mid);
            Pair right = minMax(array, mid + 1, high);

            result.min = Math.min(left.min, right.min);
            result.max = Math.max(left.max, right.max);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] array = new ArrayInput().read();
        Pair result = minMax(array, 0, array.length - 1);
        System.out.println("Maximum: " + result.max);
        System.out.println("Minimum: " + result.min);
    }
}
