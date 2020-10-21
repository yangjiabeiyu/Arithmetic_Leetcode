剑指 Offer 10- II. 青蛙跳台阶问题

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：2

/*
解法：迭代
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35 MB, 在所有 Java 提交中击败了98.58% 的用户
*/
class Solution {
    public int numWays(int n) {
        int pre = 1, cur = 1;
        for(int i = 1; i < n; i++) {
            int temp = cur;
            cur = (pre + cur) % 1000000007;
            pre = temp;
        }
        return cur;
    }
}

