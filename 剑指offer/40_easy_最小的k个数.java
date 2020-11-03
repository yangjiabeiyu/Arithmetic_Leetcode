/*
剑指 Offer 40. 最小的k个数

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]

示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]

限制：
    0 <= k <= arr.length <= 10000
    0 <= arr[i] <= 10000
*/

/*
解法：最大堆，注意初始化时，容量不能为0，所以需要先判断该情况。
执行用时：26 ms, 在所有 Java 提交中击败了15.99% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了90.65% 的用户
*/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) return new int[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        for(int i = 0; i < k; i++)
            maxHeap.add(arr[i]);      // 先建好
        for(int i = k ; i < arr.length; i++)      // 如果新的数字比堆顶元素更小，就加入
            if(arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        int[] res = new int[k];
        for(int i = 0; i < k; i++)      // 依次给到int数组
            res[i] = maxHeap.poll();
        return res;
    }
}

