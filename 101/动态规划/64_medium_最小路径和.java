/*
64. 最小路径和
https://leetcode-cn.com/problems/minimum-path-sum/
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
*/

/*
执行用时：2 ms, 在所有 Java 提交中击败了98.02% 的用户
内存消耗：41.4 MB, 在所有 Java 提交中击败了54.98% 的用户
*/
class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++)
            dp[i] = dp[i - 1] + grid[0][i];
        for(int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for(int j = 1; j < n; j++)
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
        return dp[n - 1];
    }
}


