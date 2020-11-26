/*
542. 01 矩阵
https://leetcode-cn.com/problems/01-matrix/
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1：
输入：
[[0,0,0],
 [0,1,0],
 [0,0,0]]

输出：
[[0,0,0],
 [0,1,0],
 [0,0,0]]
*/

/*
解法：先填充MAX_VALUE-1，然后再更新————左上到右下，然后右下到左上
执行用时：6 ms, 在所有 Java 提交中击败了99.68% 的用户
内存消耗：42.1 MB, 在所有 Java 提交中击败了33.80% 的用户
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0][0];
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE - 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0)
                    dp[i][j] = 0;
                else {
                    if(j > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    if(i > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
            }
        }
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][j] != 0) {
                    if(j < n - 1)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    if(i < m - 1)
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
            }
        }
        return dp;
    }
}

/*
解法二：其实要设置MAX_VALUE是因为dp[0][0]可能是1。所以只需要根据该元素取值，给一个0或者较大值即可；考虑到元素个数最多10000，这里就设置一个30000；
在第二次更新的时候，就不必再讨论dp[m-1][n-1]了，必然不会很大，因为前面必然有0.
执行用时：6 ms, 在所有 Java 提交中击败了99.68% 的用户
内存消耗：42.1 MB, 在所有 Java 提交中击败了33.41% 的用户
*/
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0][0];
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0] == 0 ? 0 : 30000;   // 先讨论dp[0][0]
        for(int i = 1; i < n; i++)
            dp[0][i] = matrix[0][i] == 0 ? 0 : dp[0][i - 1] + 1;  // 对第一行赋值
        for(int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == 0 ? 0 : dp[i - 1][0] + 1;  // 先对第一个元素讨论
            for(int j = 1; j < n; j++)
                dp[i][j] = matrix[i][j] == 0 ? 0 : Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;  // 要么上面要么左侧
        }
        for(int i = n - 2; i >= 0; i--)
            dp[m - 1][i] = Math.min(dp[m - 1][i + 1] + 1, dp[m - 1][i]);  // 对最后一行讨论
        for(int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.min(dp[i][n - 1], 1 + dp[i + 1][n - 1]);  // 先确定最后一个元素
            for(int j = n - 2; j >= 0; j--)
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]) + 1);  // 要么下面，要么右侧，要么本身
        }
        return dp;
    }
}

