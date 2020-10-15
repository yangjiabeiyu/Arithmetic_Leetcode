/*
岛屿数量
https://leetcode-cn.com/problems/number-of-islands/
题目描述
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
*/

/*
解法：深度优先，遇到的1都置0
执行用时：2 ms, 在所有 Java 提交中击败了97.66% 的用户
内存消耗：41 MB, 在所有 Java 提交中击败了92.94% 的用户
*/
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == '1') {
                    fun(grid, i, j);
                    res++;
                }
        return res;
    }
    public void fun(char[][] grid, int m, int n) {
        if(m < 0 || n < 0 || m > grid.length - 1 || n > grid[0].length - 1 || grid[m][n] == '0')
            return;
        grid[m][n] = '0';
        fun(grid, m + 1, n);
        fun(grid, m - 1, n);
        fun(grid, m, n + 1);
        fun(grid, m, n - 1);
    }
}
