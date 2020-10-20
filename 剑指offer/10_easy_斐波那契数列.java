/*
剑指 Offer 10- I. 斐波那契数列
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.

斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
解法：迭代，其实也是动态规划
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：34.9 MB, 在所有 Java 提交中击败了99.62% 的用户
*/

class Solution {
    public int fib(int n) {
        if(n == 0)
            return 0;
        int pre = 0, cur = 1;
        for(int i = 1; i < n; i++) {
            int temp = cur;
            cur = (cur + pre) % 1000000007;
            pre = temp;
        }
        return cur;
    }
}

