/*
172. 阶乘后的零
https://leetcode-cn.com/problems/factorial-trailing-zeroes/
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

说明: 你算法的时间复杂度应为 O(log n) 。
*/

/*
执行用时：1 ms, 在所有 Java 提交中击败了99.52% 的用户
内存消耗：35.3 MB, 在所有 Java 提交中击败了90.00% 的用户
*/
class Solution {
    public int trailingZeroes(int n) {
        // 主要是看5的个数，可以发现的是，每隔5个有一个5，每隔25有两个5，每隔125有3个5，所以总的个数为n/5+n/25+n/125+……
        int res = 0;
        while(n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}

