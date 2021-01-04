/*
509. 斐波那契数
https://leetcode-cn.com/problems/fibonacci-number/
斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。
*/

/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.5 MB, 在所有 Java 提交中击败了15.28% 的用户
*/
class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int pre = 0, cur = 1;
        for(int i = 1; i < n; i++) {
            int temp = pre + cur;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}

