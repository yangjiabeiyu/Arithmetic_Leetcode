/*
最小路径和
https://leetcode-cn.com/problems/minimum-path-sum/
给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
*/

/*
解法：动态规划
执行用时：4 ms, 在所有 Java 提交中击败了19.01% 的用户
内存消耗：41.3 MB, 在所有 Java 提交中击败了85.02% 的用户
*/
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        for(int i = 1; i < n; i++)
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        return dp[m - 1][n - 1];
    }
}


/*
空间优化
执行用时：2 ms, 在所有 Java 提交中击败了97.81% 的用户
内存消耗：40.8 MB, 在所有 Java 提交中击败了99.68% 的用户
*/
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++)
            dp[i] = dp[i - 1] + grid[0][i];
        for(int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for(int j = 1; j < n; j++)
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
        }       
        return dp[n - 1];
    }
}

