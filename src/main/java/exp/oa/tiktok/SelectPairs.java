package exp.oa.tiktok;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jim Z on 11/22/20 16:43
 */
public class SelectPairs {
    public int smallestLeft(int k, int[] nums) {
        if (k == 0) return 0;
        Queue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) {
            maxheap.offer(n);
        }
        for (int i = 0; i < k - 1; i++) {
            int f = maxheap.poll();
            int s = maxheap.poll();
            maxheap.offer(f - s);
        }
        return maxheap.peek();
    }
}
