/*
合并区间
https://leetcode-cn.com/problems/merge-intervals/
给出一个区间的集合，请合并所有重叠的区间。
示例
输入: intervals = [[1,3],[2,6],[8,10],[15,18]]    输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
*/

/*
解法：先对第一列排序，然后对于上下两个区间，一共有三种可能，a包含b、a和b相交、a和b相离，第一种和第二种直接取右端点的最大值，第三种情况直接新开辟一个区间
执行用时：7 ms, 在所有 Java 提交中击败了92.44% 的用户
内存消耗：41.4 MB, 在所有 Java 提交中击败了72.46% 的用户
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {     // 按照第一列排序，也可以写为：Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] res = new int[intervals.length][2];  // 创建二维数组
        int index = -1;  // 初始化下标为一，与其余情况同化
        for(int[] interval : intervals) {
            if(index == -1 || res[index][1] < interval[0])   // 如果数组为空，或者两区间相离，则新开辟
                res[++index] = interval;
            else
                res[index][1] = Math.max(res[index][1], interval[1]);   // 如果相交，则刷新右端点
        }
        return Arrays.copyOf(res, index + 1);  // 取数组的index+1
    }
}
