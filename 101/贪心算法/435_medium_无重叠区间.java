/*
435. 无重叠区间
https://leetcode-cn.com/problems/non-overlapping-intervals/
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:
    可以认为区间的终点总是大于它的起点。
    区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

示例 1:
输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
*/

/*
解法一，每次要为后面的留更多空间
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了63.25% 的用户
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (p1, p2) -> p1[0] - p2[0]);    // 按照左端点排序
        int right = intervals[0][1], res = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < right) {
                right = Math.min(right, intervals[i][1]);   // 取较小值，为后面留更多区间；取的是谁，就删除了另外一个
                res++;
            }
            else
                right = intervals[i][1];   // 若无交叠，就不用删除，只需要更新右端点
        }
        return res;
    }
}

/*
解法二：可以对右端点排序，这样如果有交叉，right就不用更新，直接删除新的区间即可。
执行用时：5 ms, 在所有 Java 提交中击败了28.75% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了92.33% 的用户
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {     // 对右端点排序
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });
        int right = intervals[0][1], res = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < right)   // 交叠，而intervals[i][1]>right，所以只需要删除区间即可
                res++;
            else
                right = intervals[i][1];  // 不交叠，需要更新右端点
        }
        return res;
    }
}


