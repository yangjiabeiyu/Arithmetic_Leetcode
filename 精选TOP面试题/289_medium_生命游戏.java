/*
289. 生命游戏
https://leetcode-cn.com/problems/game-of-life/
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
    如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
    如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
    如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
    如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

示例：
输入： 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出：
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

进阶：
    你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
    本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
*/

/*
解法：新增两个状态，2--细胞从死到活，3--细胞从活到死。先用新状态标记一下，既可以指向下次的状态，又包含了当前的状态，然后再遍历一次更新即可。
*/
class Solution {
    public void gameOfLife(int[][] board) {
        // 2: dead -> live
        // 3: live -> dead
        if(board.length == 0) return;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) {
                int n = totalNumber(board, i, j);
                if(board[i][j] == 0 && n == 3)
                    board[i][j] = 2;
                else if(board[i][j] == 1 && n != 2 && n != 3)
                    board[i][j] = 3;
            }
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == 2)      // 从死到活
                    board[i][j] = 1;
                else if(board[i][j] == 3)  / /从活到死
                    board[i][j] = 0;
    }
    public int totalNumber(int[][] board, int m, int n) {       // 周围8个
        return liveNumber(board, m + 1, n) + liveNumber(board, m + 1, n + 1)
             + liveNumber(board, m + 1, n - 1) + liveNumber(board, m, n - 1)
             + liveNumber(board, m, n + 1) + liveNumber(board, m - 1, n)
             + liveNumber(board, m - 1, n + 1) + liveNumber(board, m - 1, n - 1);
    }
    public int liveNumber(int[][] board, int m, int n) {   // 判断当前位置细胞的死活
        if(m < 0 || m >= board.length || n < 0 || n >= board[0].length)
            return 0;
        if(board[m][n] == 0 || board[m][n] == 2)  // 这里也可以是board[m][n] % 2 == 0
            return 0;
        return 1;
    }
}

