package exp.oa.tigergraph;

import leetcode.LC295_FindMedianFromDataStream;

import java.util.*;

/**
 * Created by Jim Z on 11/3/20 13:52
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 *
 * Note:
 * You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
 * Answers within 10^-5 of the actual value will be accepted as correct.
 */
public class LC480_SlidingWindowMedian extends LC295_FindMedianFromDataStream {

    // this will be the ultimate solution to speed up the remove time complexity
    public double[] twoTreeSets(int[] nums, int k) {
        if (k > nums.length) return new double[]{0};
        double[] ans = new double[nums.length - k + 1];
        Comparator<Integer> cmp = (o1, o2) -> {
            if (nums[o1] == nums[o2]) {
                return o1 - o2; // when equal numbers we sort the index of them
            } else {
                return new Integer(nums[o1]).compareTo(nums[o2]);
            }
        };

        TreeSet<Integer> min = new TreeSet<>(cmp);
        TreeSet<Integer> max = new TreeSet<>(cmp.reversed());

        for (int i= 0; i < k; i++) {
            twoTreeSets_addNum(i, nums, min, max);
        }
        ans[0] = twoTreeSets_findMedian(nums, min, max);

        for (int i = k; i < nums.length; i++) {
            twoTreeSets_addNum(i, nums, min, max);
            twoTreeSets_deleteNum(i - k, nums, min, max);
            ans[i -k+1] = twoTreeSets_findMedian(nums, min, max);
        }
        return ans;
    }

    private void twoTreeSets_addNum(int i, int[] nums, TreeSet<Integer> min, TreeSet<Integer> max) {
        // use min store the bigger half
        if (min.isEmpty() || nums[i] >= nums[min.first()]) {
            min.add(i);
        // use max store the lesser half
        } else if (max.isEmpty() || nums[i] <= nums[max.first()]) {
            max.add(i);
        // store between min and max to min, since we want to remain the min size bigger
        } else {
            min.add(i);
        }
        maintain_order(min, max);
    }

    private void twoTreeSets_deleteNum(int i, int[] nums, TreeSet<Integer> min, TreeSet<Integer> max) {
        if (min.contains(i)) {
            min.remove(i);
        } else {
            max.remove(i);
        }
        maintain_order(min, max);
    }

    private double twoTreeSets_findMedian(int[] nums, TreeSet<Integer> min, TreeSet<Integer> max) {
        if (min.size() == max.size()) {
            return nums[min.first()] / 2.0 + nums[max.first()] /2.0;
        } else {
            // since the min set will always store the odd answer
            return nums[min.first()];
        }
    }

    /*
     *  Always keep the min tree set have the odd median answer
     */
    private void maintain_order(TreeSet<Integer> min, TreeSet<Integer> max) {
        while (min.size() != max.size() && min.size() - max.size() != 1) {
            if (min.size() > max.size()) {
                max.add(min.pollFirst());
            } else {
                min.add(max.pollFirst());
            }
        }
    }

    // idea comes from LC 295
    public double[] twoPriorityQueues(int[] nums, int k) {
        if (k > nums.length) return new double[]{0};
        double[] ans = new double[nums.length - k + 1];
        // maxheap store the first half of sorted list
        // minheap store thr rest half
        Queue<Integer> minheap = new PriorityQueue<>();
        Queue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i= 0; i < k; i++) {
            twoPriorityQueues_addNum(nums[i], minheap, maxheap);
        }
        ans[0] = twoPriorityQueues_findMedian(minheap, maxheap);

        for (int i = k; i < nums.length; i++) {
            twoPriorityQueues_addNum(nums[i], minheap, maxheap);
            twoPriorityQueues_deleteNum(nums[i - k], minheap, maxheap);
            ans[i -k+1] = twoPriorityQueues_findMedian(minheap, maxheap);
        }
        return ans;
    }

    private void twoPriorityQueues_addNum(int num, Queue<Integer> min, Queue<Integer> max) {
        if (min.isEmpty() || num >= min.peek()) {
            min.offer(num);
        } else if (max.isEmpty() || num <= max.peek()) {
            max.offer(num);
        } else {
            min.offer(num);
        }
        // maintain the size
        while (min.size() != max.size() && min.size() - max.size() != 1) {
            if (min.size() > max.size()) {
                max.offer(min.poll());
            } else {
                min.offer(max.poll());
            }
        }
    }

    private void twoPriorityQueues_deleteNum(int num, Queue<Integer> min, Queue<Integer> max) {
        if (num >= min.peek()) {
            min.remove(num);
        } else {
            max.remove(num);
        }

        while (min.size() != max.size() && min.size() - max.size() != 1) {
            if (min.size() > max.size()) {
                max.offer(min.poll());
            } else {
                min.offer(max.poll());
            }
        }
    }

    private double twoPriorityQueues_findMedian(Queue<Integer> min, Queue<Integer> max) {
        if (min.size() == max.size()) {
            return min.peek() * 0.5 + max.peek() * 0.5;
        } else {
            return min.peek();
        }
    }

    /*
    This is the naive way to solve the problem
     */
    public double[] bruteForce(int[] nums, int k) {
        int i = 0;
        double[] ans = new double[nums.length - k + 1];
        while (i + k - 1 < nums.length) {
            ans[i] = bruteForce_findMedian(nums, i , i + k -1);
            i++;
        }
        return ans;
    }

    private double bruteForce_findMedian(int[] nums, int i, int j) {
        int len = j -i + 1;
        int[] arr = new int[len];
        for (int k = 0; k + i <= j; k++) {
            arr[k] = nums[k + i];
        }
        Arrays.sort(arr);
        if (len % 2 != 0) {
            return arr[len /2];
        } else {
            return ( (long)arr[(len -1) /2] + (long)arr[len /2] ) / 2.0;
        }
    }
}
