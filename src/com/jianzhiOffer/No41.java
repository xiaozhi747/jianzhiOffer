package com.jianzhiOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * Created by 林智 on 2018/6/13.
 */
public class No41 {

    // 大根堆要放前一半小的数, 小根堆要放后一半大的数
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new DescComparator());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new AsceComparator());
    private static int count = 0;

    public static void Insert(Integer num) {
        // 实际上  不管是偶数还是奇数时,加入大根堆还是小根堆都可以是随意的, 只要选择好一个规则去遵循就可以了
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public static Double GetMedian() {
        if (maxHeap.size() + minHeap.size() == 0) {
            return null;
        }
        if (maxHeap.size() > minHeap.size()) {
            return new Double(maxHeap.peek());
        } else if (maxHeap.size() < minHeap.size()){
            return new Double(minHeap.peek());
        } else {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    /**
     * 降序排序
     */
    public static class DescComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    /**
     * 升序
     */
    public static class AsceComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

}
