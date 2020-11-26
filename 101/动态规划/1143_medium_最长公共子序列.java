/*
1143. 最长公共子序列
https://leetcode-cn.com/problems/longest-common-subsequence/
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

示例 1:
输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
*/

/*
动态规划
执行用时：12 ms, 在所有 Java 提交中击败了72.27% 的用户
内存消耗：42 MB, 在所有 Java 提交中击败了90.22% 的用户
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];  // 可以理解为从空字符串到完整的字符串
        int start1 = 0, start2 = 0;
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))  // 如果相等，就直接i-1和j-1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // 不相等，就分别退一步
            }
        return dp[m][n];
    }
}

