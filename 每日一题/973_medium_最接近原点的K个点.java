/*
973. 最接近原点的 K 个点
https://leetcode-cn.com/problems/k-closest-points-to-origin/
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
（这里，平面上两点之间的距离是欧几里德距离。）
你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。

示例 1：
输入：points = [[1,3],[-2,2]], K = 1
输出：[[-2,2]]
解释： 
(1, 3) 和原点之间的距离为 sqrt(10)，
(-2, 2) 和原点之间的距离为 sqrt(8)，
由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。

示例 2：
输入：points = [[3,3],[5,-1],[-2,4]], K = 2
输出：[[3,3],[-2,4]]
（答案 [[-2,4],[3,3]] 也会被接受。）
*/

/*
解法：最大堆。两种思路，一种是将坐标放入堆中；另一种是将距离平方和索引放入堆中。
执行用时：32 ms, 在所有 Java 提交中击败了53.92% 的用户
内存消耗：46.7 MB, 在所有 Java 提交中击败了90.76% 的用户
*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                return arr2[0] * arr2[0] + arr2[1] * arr2[1] - arr1[0] * arr1[0] - arr1[1] * arr1[1];
            }
        });
        // 第二种写法：PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, (a, b) -> b[0]*b[0]+ b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
        for(int i = 0; i < K; i++)
            maxHeap.offer(points[i]);
        for(int i = K; i < points.length; i++) {
            if(maxHeap.comparator().compare(points[i], maxHeap.peek()) > 0) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++)
            res[i] = maxHeap.poll();
        return res;
    }
}

