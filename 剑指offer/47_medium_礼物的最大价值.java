/*
剑指 Offer 47. 礼物的最大价值
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
示例 1:
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法：dp
执行用时：3 ms, 在所有 Java 提交中击败了82.78% 的用户
内存消耗：40.8 MB, 在所有 Java 提交中击败了99.14% 的用户
*/
class Solution {
    public int maxValue(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i = 1; i < n; i++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        return dp[m-1][n-1];
    }
}

/*
空间优化
执行用时：2 ms, 在所有 Java 提交中击败了98.33% 的用户
内存消耗：40.8 MB, 在所有 Java 提交中击败了99.67% 的用户
*/
class Solution {
    public int maxValue(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++)
            dp[i] = dp[i-1] + grid[0][i];
        for(int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for(int j = 1; j < n; j++)
                dp[j] = Math.max(dp[j-1], dp[j]) + grid[i][j];
        }
        return dp[n-1];
    }
}

