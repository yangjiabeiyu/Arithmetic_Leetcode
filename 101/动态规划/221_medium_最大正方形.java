/*
221. 最大正方形
https://leetcode-cn.com/problems/maximal-square/
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
示例：
输入：
matrix = [["1","0","1","0","0"],
          ["1","0","1","1","1"],
          ["1","1","1","1","1"],
          ["1","0","0","1","0"]]
输出：4
*/

/*
执行用时：6 ms, 在所有 Java 提交中击败了82.29% 的用户
内存消耗：41.5 MB, 在所有 Java 提交中击败了90.82% 的用户
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] dp = new int[m + 1][n + 1];   // 方便处理边界
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                if(matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(dp[i][j], res);
                }
        return res * res;
    }
}


