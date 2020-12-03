package exp.oa.tigergraph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jim Z on 11/9/20 14:52
 *
 * A team organizing a university career fair has a list of companies along with their respective arrival times and their duration of stay. Only one company can present at any time. Given each company's arrival time and the duration they will stay, determine the maximum number of presentations that can be hosted during the career fair
 *
 * Example:
 * n = 5
 * arrival  = [1, 3, 3, 5, 7]
 * duration = [2, 2, 1, 2, 1]
 *
 */
public class UniversityCareerFair {
    public int maxEvents(List<Integer> arrival, List<Integer> duration) {
        Queue<int[]> queue = new PriorityQueue<>(
                (o1, o2) ->
                        o1[1] == o2[1] ?
                                Integer.compare(o1[0], o2[0]) :
                                Integer.compare(o1[1], o2[1])
        );

        for (int i = 0; i < arrival.size(); i++) {
            queue.offer(new int[]{arrival.get(i), duration.get(i)});
        }

        int ans = 0;
        int end = -1;

        for (int[] inc : queue) {
            if (end <= inc[0]) {
                ans++;
                end = inc[0] + inc[1];
            }
        }

        return ans;
    }
}
