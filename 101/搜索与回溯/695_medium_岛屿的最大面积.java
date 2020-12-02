/*
695. 岛屿的最大面积
https://leetcode-cn.com/problems/max-area-of-island/
给定一个包含了一些 0 和 1 的非空二维数组 grid 。
一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]

对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
*/

/*
解法：dfs
*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                res = Math.max(res, dfs(grid, i, j));
        return res;
    }
    public int dfs(int[][] grid, int m, int n) {
        if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == 0)
            return 0;
        grid[m][n] = 0;    // 这里不用复原，如果需要保持grid矩阵，那就需要了
        return 1 + dfs(grid, m, n + 1) + dfs(grid, m, n - 1) + dfs(grid, m - 1, n) + dfs(grid, m + 1, n);
    }
}

