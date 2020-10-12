package exp.oa.amazon;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jim Z on 2020-09-24 16:34
 * <p>
 * TAGS: Amazon, OA, NG, 2020
 * <p>
 * An Amazon warehouse manager need to create a shipment to fill a truck. All of the products in the warehouse are in boxes of the same size. Each product is packed in some number of units per box.
 * <p>
 * Given the number of boxes the truck can hold, write an algorithm to determine the maximum number of units of any mix of products that can be shipped
 * <p>
 * Input
 * The input tot the function/method consists of five arguments:
 * num, an integer representing number of products;
 * boxes, a list of integers representing the number of available boxes for products;
 * unitSize, an integer representing size of unitsPerBox;
 * unitsPerBox, a list of integers representing the number of unit packed in each box;
 * truckSize, an integer representing the number of boxes the truck can carry;
 * <p>
 * Output
 * Return an integer representing the maximum units that can be carried by the truck
 */
public class MaximumUnits {
    private class UnitAndBoxes {
        private int numOfBoxes;
        private int numOfUnits;

        public UnitAndBoxes(int b, int u) {
            this.numOfBoxes = b;
            this.numOfUnits = u;
        }
    }

    public int calTheMax(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {
        int ans = 0;
        Queue<UnitAndBoxes> maxheap = new PriorityQueue<>((o1, o2) -> o2.numOfUnits - o1.numOfUnits);
        // create the priority queue, let the max unitsPerBox on the top
        for (int i = 0; i < num; i++) {
            maxheap.offer(new UnitAndBoxes(boxes.get(i), unitsPerBox.get(i)));
        }
        // we can greedy load max unitsPerBox to truck, since the box size is same, and we need max num of units of product
        // When truck have space AND we have products not be loaded
        while (truckSize > 0 && !maxheap.isEmpty()) {
            UnitAndBoxes temp = maxheap.poll();
            int n = temp.numOfBoxes;
            int u = temp.numOfUnits;
            while (n > 0 && truckSize > 0) {
                ans += u;
                n --;
                truckSize --;
            }
        }

        return ans;
    }
}
