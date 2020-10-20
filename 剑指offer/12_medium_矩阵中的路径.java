/*
剑指 Offer 12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法：dfs
执行用时：6 ms, 在所有 Java 提交中击败了77.66% 的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了92.58% 的用户
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
            return true;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == word.charAt(0) && exist(board, word, i, j, 0))       // 此处不判断相等也可，总之就是遍历入口
                    return true;
        return false;
    }
    public boolean exist(char[][] board, String word, int row, int col, int pos) {
        if(pos >= word.length())
            return true;
        int m = board.length, n = board[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || word.charAt(pos) != board[row][col])
            return false;
        char ch = board[row][col];
        board[row][col] = '0';                                                       // 先置为别的字符，否则可能重复使用
        boolean res = exist(board, word, row + 1, col, pos + 1)
                   || exist(board, word, row - 1, col, pos + 1)
                   || exist(board, word, row, col + 1, pos + 1)
                   || exist(board, word, row, col - 1, pos + 1);
        board[row][col] = ch;
        return res;
    }
}


