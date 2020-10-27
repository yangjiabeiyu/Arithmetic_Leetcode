/*
剑指 Offer 14- II. 剪绳子 II
https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

示例 2:
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
*/


/*
解法一：循环取余：相比于剪绳子I，此处需要取余，区域公式有x^n % p = (x^(n-1)%p * (x%p)) % p = (x^(n-1)%p * x) % p，
所以可以有递推公式res = res*x % p。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：34.9 MB, 在所有 Java 提交中击败了98.62% 的用户
*/
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3)
            return n - 1;
        long res = 1L;
        while(n > 4) {
            n -= 3;
            res = res * 3 % 1000000007;
        }
        return (int)(res * n % 1000000007);
    }
}

/*
解法二：快速幂取余，其实就是循环取余的时候，每次res*3；这边是每次res*3，res*9，res*81，等等。
x^n % p = (x*x)^(n/2) % p = (x*x % p)^(n/2) % p; 若n为偶数，则即是如此；若n为奇数，那么有x^n % p = (x*(x*x % p)^(n/2)) % p。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.4 MB, 在所有 Java 提交中击败了76.09% 的用户
*/
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3)
            return n - 1;
        long res = 1L, x = 3;
        for(int i = n / 3 - 1; i > 0; i /= 2) {
            if(i % 2 == 1)
                res = (res * x) % 1000000007;
            x = x * x % 1000000007;
        }
        if(n % 3 == 0)
            return (int)(res * 3 % 1000000007);
        if(n % 3 == 1)
            return (int)(res * 4 % 1000000007);
        return (int)(res * 6 % 1000000007);
    }
}

