import java.util.Scanner;

class DataObject {
    int profit;
    int weight;
    double pw;
}

public class KnapSack {
    DataObject d[];
    int n, max;

    Scanner sc;

    public KnapSack() {
        sc = new Scanner(System.in);
        System.out.println("Enter number of objects");
        n = sc.nextInt();
        d = new DataObject[n];
        for (int i = 0; i < n; i++) {
            d[i] = new DataObject();
            System.out.println("Enter profit");
            d[i].profit = sc.nextInt();
            System.out.println("Enter weight");
            d[i].weight = sc.nextInt();
            d[i].pw = (double) d[i].profit / d[i].weight;
        }
    }

    public void calculate() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (d[i].pw < d[j].pw) {
                    DataObject temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }

        int s = 0;
        int k = 0;
        while (max > 0 && k < n) {
            if (max >= d[k].weight) {
                max -= d[k].weight;
                s += d[k].profit;
            } else {
                s += max * d[k].pw;
                max = 0;
            }
            k++;
        }
        System.out.println("Final profit: " + s);
    }

    public static void main(String[] args) {
        KnapSack k = new KnapSack();
        System.out.println("Enter maximum weight capacity:");
        Scanner sc = new Scanner(System.in);
        k.max = sc.nextInt();
        sc.close();
        k.calculate();
    }
}
