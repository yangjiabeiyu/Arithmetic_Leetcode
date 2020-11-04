/*
57. 插入区间
https://leetcode-cn.com/problems/insert-interval/
给出一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1：
输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]

示例 2：
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠
*/

/*
解法：主要是找到插入点，逻辑比较重要
执行用时：1 ms, 在所有 Java 提交中击败了99.65% 的用户
内存消耗：41 MB, 在所有 Java 提交中击败了62.39% 的用户
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        boolean flag = false;
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) {
            if(interval[0] > right) {    // 如果新区间在合并区间的右边
                if(!flag) {  // 合并区间还未安置，那么先把合并区间加进去
                    list.add(new int[] {left, right});
                    flag = true;
                }
                list.add(interval);   // 把新区间加进去
            }
            else if(interval[1] < left)   // 如果在合并区间的左侧，那么直接加进去即可
                list.add(interval);
            else {              // 如果新区间是需要合并的
                left = Math.min(left, interval[0]);    // 更新合并区间的左边界和右边界
                right = Math.max(right, interval[1]);
            }
        }
        if(!flag)   // 如果合并区间还未安置，则最后加上去
            list.add(new int[] {left, right});
        int[][] res = new int[list.size()][2];   // 列表转二维数组
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
