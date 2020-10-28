/*
371. 两整数之和
https://leetcode-cn.com/problems/sum-of-two-integers/
不使用运算符 + 和 -，计算两整数 a 、b 之和。

示例 1:
输入: a = 1, b = 2
输出: 3

示例 2:
输入: a = -2, b = 3
输出: 1
*/

/*
解法：位运算，进位是a异或b，当前位是a与b。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：34.9 MB, 在所有 Java 提交中击败了98.51% 的用户
*/
class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

