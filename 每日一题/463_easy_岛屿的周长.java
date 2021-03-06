/*
463. 岛屿的周长

给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

示例 :
输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
输出: 16
*/

/*
解法：dfs，对于遍历后的网格，需要置为2或者其他数字
执行用时：10 ms, 在所有 Java 提交中击败了48.91% 的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了11.75% 的用户
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)
                    return dfs(grid, i, j);
        return 0;
    }
    public int dfs(int[][] grid, int m, int n) {
        if(m < 0 || m >= grid.length || n < 0 || n >= grid[0].length || grid[m][n] == 0)
            return 1;
        if(grid[m][n] == 2) return 0;
        grid[m][n] = 2;
        return dfs(grid, m + 1, n) + dfs(grid, m - 1, n) + dfs(grid, m, n + 1) + dfs(grid, m, n - 1);
    }
}


