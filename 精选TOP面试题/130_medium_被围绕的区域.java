/*
130. 被围绕的区域
https://leetcode-cn.com/problems/surrounded-regions/
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:
X X X X
X O O X
X X O X
X O X X

运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X

解释:
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/

/*
解法：该题直接dfs的话是有问题的，例如
X X X
X O X
O O O
这样在搜寻(3,2)的时候，先把自己置为X，向上寻找会发现四面都是X，从而置为X，而这样显然不对。
该题的思路是先在边界找，意思是先找到不会置为X的O，这就比较简单，遇见X就返回即可。
执行用时：2 ms, 在所有 Java 提交中击败了96.68% 的用户
内存消耗：40.8 MB, 在所有 Java 提交中击败了73.81% 的用户
*/
class Solution {
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int m = board.length - 1, n = board[0].length - 1;
        for(int i = 0; i <= m; i++) {
            if(board[i][0] == 'O')
                dfs(board, i, 0);
            if(board[i][n] == 'O')
                dfs(board, i, n);
        }
        for(int i = 0; i <= n; i++) {
            if(board[0][i] == 'O')
                dfs(board, 0, i);
            if(board[m][i] == 'O')
                dfs(board, m, i);
        }
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == 'O')              // 仍为O的字符，说明被包围了，应该置为X
                    board[i][j] = 'X';
                else if(board[i][j] == 'A')         // 对于置为A的字符，应该恢复到O
                    board[i][j] = 'O';
    }
    public void dfs(char[][] board, int m, int n) {
        if(m < 0 || m >= board.length || n < 0 || n >= board[0].length || board[m][n] != 'O')
            return;
        board[m][n] = 'A';    // 先置为其他字符。
        dfs(board, m + 1, n);
        dfs(board, m - 1, n);
        dfs(board, m, n + 1);
        dfs(board, m, n - 1);
    }
}

