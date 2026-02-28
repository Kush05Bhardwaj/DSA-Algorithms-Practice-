import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;
    double ratio;

    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxProfit(Item[] items, int capacity) {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                if (a.ratio < b.ratio)
                    return 1;
                else if (a.ratio > b.ratio)
                    return -1;
                else
                    return 0;
            }
        });

        double totalProfit = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                totalProfit += item.value;
                remainingCapacity -= item.weight;
            } else {
                double fraction = (double) remainingCapacity / item.weight;
                totalProfit += item.value * fraction;
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        int capacity = 50;
        double maxProfit = getMaxProfit(items, capacity);
        System.out.println("Maximum profit in Knapsack = " + maxProfit);
    }
}
