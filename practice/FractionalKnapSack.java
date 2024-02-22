package practice;

import java.util.Arrays;
import java.util.Scanner;

class Item {
    double profit, weight, p_w_ratio;

    public Item(double profit, double weight) {
        this.profit = profit;
        this.weight = weight;
        this.p_w_ratio = profit / weight;
    }
    
}

public class FractionalKnapSack {
    public static double[] getProfitAndWeight(String both) {
        double[] values = new double[2];
        String[] splited = both.split(" ");
        values[0] = Double.parseDouble(splited[0]);
        values[1] = Double.parseDouble(splited[1]);
        return values;
    }
    public static void main(String[] args) {
        double max_weight;
        int num_items;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        num_items = sc.nextInt();
        System.out.print("Enter the max desired weigth: ");
        max_weight = sc.nextDouble();
        sc.nextLine();
        Item[] items = new Item[num_items];

        for (int i = 0; i < num_items; i++) {
            System.out.print("Enter profit and weight for item " + (i+1) + " seperated by space: ");
            double[] values = getProfitAndWeight(sc.nextLine());
            items[i] = new Item(values[0], values[1]);
        }
        sc.close();

        Arrays.sort(items, (a , b) -> Double.compare(b.p_w_ratio , a.p_w_ratio));

        double max_profit = 0;
        int i;
        for(i = 0; max_weight > 0 && i < num_items; i++) {
            if( items[i].weight <= max_weight ){
                max_profit += items[i].profit;
                max_weight -= items[i].weight;
            } else {
                max_profit += max_weight * items[i].p_w_ratio;
                break;
            }
        }

        System.out.println("Maximum profit: "+ max_profit);
    }
}
