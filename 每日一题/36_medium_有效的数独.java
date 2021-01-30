/*
36. 有效的数独
https://leetcode-cn.com/problems/valid-sudoku/
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
*/

/*
解法一：比较朴素地分别从三个维度判断是否有重复
执行用时：3 ms, 在所有 Java 提交中击败了54.94% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了89.81% 的用户
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
            }
        }
        for(int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.' && !set.add(board[j][i]))
                    return false;
            }
        }
        for(int i = 0; i < 7; i += 3) {
            for(int j = 0; j < 7; j += 3) {
                Set<Character> set = new HashSet<>();
                for(int k1 = 0; k1 < 3; k1++)
                    for(int k2 = 0; k2 < 3; k2++)
                        if(board[i + k1][j + k2] != '.' && !set.add(board[i + k1][j + k2]))
                            return false;
            }
        }
        return true;
    }
}

/*
解法二：可以各设置9个hashset，然后遍历board，对应到各set，看看有没有重复的
执行用时：3 ms, 在所有 Java 提交中击败了54.94% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了28.75% 的用户
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] setRow = new HashSet[9];
        Set<Character>[] setCol = new HashSet[9];
        Set<Character>[] setSub = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            setRow[i] = new HashSet<>();
            setCol[i] = new HashSet<>();
            setSub[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if(ch != '.') {
                    if(!setRow[i].add(ch) || !setCol[j].add(ch) || !setSub[(i/3) * 3 + j/3].add(ch))
                        return false;
                }
            }
        }
        return true;
    }
}

