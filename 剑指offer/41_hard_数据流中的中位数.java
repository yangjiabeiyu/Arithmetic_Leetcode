/*
剑指 Offer 41. 数据流中的中位数
https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。

示例 1：
输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]

示例 2：
输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]
*/

/*
解法：主要是要实时排序，所以最不济是用链表实现，但是复杂度高；此时可以利用最大堆与最小堆；最大堆中存储前一半小的数字；最小堆存储后一半大的数字；
最小堆的size大于等于最大堆的size。这里主要是添加时的逻辑。
执行用时：93 ms, 在所有 Java 提交中击败了20.49% 的用户
内存消耗：49.7 MB, 在所有 Java 提交中击败了80.41% 的用户
*/
class MedianFinder {
    Queue<Integer> minHeap, maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();                       // 存储前一半大的数字
        maxHeap = new PriorityQueue<>((a, b) -> b - a);        // 存储后一半大的数字
    }
    
    public void addNum(int num) {
        if(minHeap.size() != maxHeap.size()) {                 // 此时需要向最大堆添加元素，为了保持有序，需要先加在最小堆，然后把堆顶元素加入最大堆。
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        else {                                                 // 向最小堆添加元素，需要先加入最大堆，然后把堆顶元素加入最小堆。
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();  // 如果size相同，则取平均；否则就是最小堆的堆顶元素
    }
}




