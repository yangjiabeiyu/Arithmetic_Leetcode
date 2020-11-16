/*
119. 杨辉三角 II
https://leetcode-cn.com/problems/pascals-triangle-ii/
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 3
输出: [1,3,3,1]

进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？
*/

/*
解法：排列组合
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.2 MB, 在所有 Java 提交中击败了72.22% 的用户
*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        long num = 1;
        for(int i = 1; i <= rowIndex; i++) {
            num = num * (rowIndex - i + 1) / i;
            res.add((int)num);
        }
        return res;
    }
}

