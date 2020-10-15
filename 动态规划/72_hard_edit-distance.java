/*
编辑距离
https://leetcode-cn.com/problems/edit-distance/
题目描述
给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符
示例
输入：word1 = "horse", word2 = "ros"    输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
*/

/*
解法：动态规划
执行用时：7 ms, 在所有 Java 提交中击败了47.08% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了99.35% 的用户
*/
class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j] = min{dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]}  if word1(i)==word2(j)(不需要改)
        // dp[i][j] = min{dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1}  if word1(i)!=word2(j)(需要改)
        // dp[i][j]，表示word1前i个字符到word2前j个字符的最小编辑距离
        // 1、删除第i个，所以有dp[i][j] = dp[i-1][j] + 1
        // 2、word1后面增加第i+1个字符，与word2第j个相同，所以只需要比较word1前i个与word2前j-1的最小编辑距离，dp[i][j] = dp[i][j-1] + 1
        // 3、如果i和j不同，也可以进行更改，dp[i][j] = dp[i-1][j-1]+1; 如果相同，则只需比较前i-1与前j-1，dp[i][j] = dp[i-1][j-1]
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;
        for(int i = 0; i <= n; i++)
            dp[0][i] = i;
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            }
        return dp[m][n];
    }
}
