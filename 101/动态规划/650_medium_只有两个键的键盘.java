/*
650. 只有两个键的键盘
https://leetcode-cn.com/problems/2-keys-keyboard/
最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：

    Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
    Paste (粘贴) : 你可以粘贴你上一次复制的字符。

给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。

示例 1:

输入: 3
输出: 3
解释:
最初, 我们只有一个字符 'A'。
第 1 步, 我们使用 Copy All 操作。
第 2 步, 我们使用 Paste 操作来获得 'AA'。
第 3 步, 我们使用 Paste 操作来获得 'AAA'。
*/

/*
解法一：dp，找到因数，然后复制。
执行用时：50 ms, 在所有 Java 提交中击败了13.86% 的用户
内存消耗：35.4 MB, 在所有 Java 提交中击败了65.89% 的用户
*/
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(i % j == 0)
                    dp[i] = Math.min(dp[j] + i / j, dp[i]);
            }
        }
        return dp[n];
    }
}

/*
解法二：对于i，找到除本身的最大因数即可。两个因子为m和n，那么dp[m*n] = dp[m]+dp[n]；
这可以理解为先得到dp[m],然后将m作为一个整体，复制为n个m，那么需要的次数就是dp[n]，总次数为dp[m]+dp[n]。
执行用时：8 ms, 在所有 Java 提交中击败了33.75% 的用户
内存消耗：35.6 MB, 在所有 Java 提交中击败了40.40% 的用户
*/
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            dp[i] = i;
            for(int j = 2; j <= i / 2; j++)
                if(i % j == 0) {
                    dp[i] = dp[i / j] + dp[j];
                    break;
                }
        }
        return dp[n];
    }
}


