/*
单词搜索
https://leetcode-cn.com/problems/word-search/
题目描述
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
*/

/*
解题思路：深度优先，需要注意的是因为不能重复使用，所以需要将当前位置的字符先设置为某个其他字符，如'0'，然后调用结束后再还原。
执行用时：6 ms, 在所有 Java 提交中击败了90.44% 的用户
内存消耗：40.7 MB, 在所有 Java 提交中击败了66.38% 的用户
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0)
            return false;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(word.charAt(0) == board[i][j] && exist(board, word, i, j, 0))     // 先找到入口
                    return true;
        return false;
    }
    public boolean exist(char[][] board, String word, int row, int col, int k) {
        if(word.length() == k)
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(k))  // 判断字符位置是否合理，若合理是否与指定字符相同
            return false;
        char temp = board[row][col];
        board[row][col] = '0';
        boolean res = exist(board, word, row - 1, col, k + 1)   // 四个方向搜索
        || exist(board, word, row + 1, col, k + 1)
        || exist(board, word, row, col - 1, k + 1)
        || exist(board, word, row, col + 1, k + 1);
        board[row][col] = temp;  // 还原字符
        return res;
    }
}
