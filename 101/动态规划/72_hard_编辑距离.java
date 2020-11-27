/*
72. 编辑距离
https://leetcode-cn.com/problems/edit-distance/
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符

示例 1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

提示：
    0 <= word1.length, word2.length <= 500
    word1 和 word2 由小写英文字母组成
*/

/*
dp
执行用时：7 ms, 在所有 Java 提交中击败了42.61% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了83.43% 的用户
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len2; i++)
            dp[0][i] = i;
        for(int i = 1; i <= len1; i++)
            dp[i][0] = i;
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
            }
        }
        return dp[len1][len2];
    }
}

