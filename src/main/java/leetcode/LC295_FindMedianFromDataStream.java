package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jim Z on 11/4/20 02:38
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class LC295_FindMedianFromDataStream {
    /*
        First lets discuss the idea.
        Find median of stream
        Keyword: median, stream
            median -> sorted.
            sort stream -> priority queue
            median -> the middle of sorted -> divide to two priority queue
            one is max heap other is min heap. Connected two will have one sorted
     */
    private Queue<Integer> minheap;
    private Queue<Integer> maxheap;

    public LC295_FindMedianFromDataStream() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        // let's keep minheap size bigger to keep the odd size median
        // keep the size diff <= 1
        // first insert than maintain size
        if (minheap.isEmpty() || num >= minheap.peek()) {
            minheap.offer(num);
        } else if (maxheap.isEmpty() || num <= maxheap.peek()) {
            maxheap.offer(num);
        } else {
            minheap.offer(num);
        }
        // fix it if minheap != maxheap and minheap - maxheap != 1
        while (minheap.size() != maxheap.size() && minheap.size() - maxheap.size() != 1) {
            if (maxheap.size() > minheap.size()) {
                minheap.offer(maxheap.poll());
            } else {
                maxheap.offer(minheap.poll());
            }
        }
    }

    public double findMedian() {
        if (minheap.size() == maxheap.size()) {
            return minheap.peek() / 2.0 + maxheap.peek() / 2.0;
        } else {
            return minheap.peek();
        }
    }
}
