/*
215. 数组中的第K个最大元素
https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
*/

/*
解法一：最小堆，先建好堆；如果新的数字比最小值大，那么就先弹出堆顶元素，然后加入新数字。
执行用时：4 ms, 在所有 Java 提交中击败了60.96% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了87.37% 的用户
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);  // 最大堆
        for(int i = 0; i < k; i++)
            minHeap.add(nums[i]);
        for(int i = k; i < nums.length; i++)
            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        return minHeap.peek();
    }
}

/*
解法二：最大堆；把所有数字建堆，然后弹k个数字即可。
执行用时：6 ms, 在所有 Java 提交中击败了51.71% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了92.75% 的用户
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);  // 最大堆
        for(int i = 0; i < nums.length; i++)
            maxHeap.add(nums[i]);
        for(int i = 0; i < k - 1; i++)
            maxHeap.poll();
        return maxHeap.peek();
    }
}

