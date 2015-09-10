import java.io.File;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class StoreCredit {
    
    public static void credits(int c, int credits, int[] items) {
        Map<Integer,Integer> item_map = new HashMap<Integer,Integer>();
        for (int i=0; i<items.length; i++) {
            item_map.put(items[i], i);
        }

        int i1 = 0;
        int i2 = 0;
        for (int i=0;i < items.length; i++) {
            int item = items[i];
            int remaining = credits - item;
            if (item_map.containsKey(remaining)) {
                i1 = Math.min(item_map.get(item), item_map.get(remaining)) + 1;
                i2 = Math.max(item_map.get(item), item_map.get(remaining)) + 1;
                break;
            }
        }
        System.out.println("Case #" + c + ": " + Integer.toString(i1) + " " + Integer.toString(i2));
    }
    
    public static void main(String[] args) {
        File file = new File("A-small-practice.in");
        
        try {
            Scanner s = new Scanner(file);
            int N = s.nextInt();

            for (int i=0; i<N; i++) {
                int credits = s.nextInt();
                int I = s.nextInt();
                int[] items = new int[I];
                for (int j=0; j<I; j++) {
                    items[j] = s.nextInt();
                }

                credits(i+1, credits, items);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        
    }

    
}