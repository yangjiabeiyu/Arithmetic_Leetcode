/*
37. 解数独
https://leetcode-cn.com/problems/sudoku-solver/
编写一个程序，通过填充空格来解决数独问题。
一个数独的解法需遵循如下规则：
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
*/

/*
解法：使用回溯对空格进行填充，各使用9个hashset判断重复情况
执行用时：16 ms, 在所有 Java 提交中击败了32.33% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了8.58% 的用户
*/
class Solution {
    public void solveSudoku(char[][] board) {
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
                if(ch != '.') {  // 记录下来已经存在的
                    setRow[i].add(ch);
                    setCol[j].add(ch);
                    setSub[(i/3) * 3 + j/3].add(ch);
                }
            }
        }
        dfs(0, board, setRow, setCol, setSub);
    }
    public boolean dfs(int num, char[][] board, Set[] setRow, Set[] setCol, Set[] setSub) {
        while(num < 81 && board[num/9][num%9] != '.')
            num++;
        if(num == 81) return true;  // 如果后面没有可填的，就结束
        int i = num / 9, j = num % 9;
        for(int cnt = 1; cnt < 10; cnt++) {  // 逐个测试，看哪个数字能用
            char ch = (char)('0' + cnt);
            if(!setRow[i].contains(ch) && !setCol[j].contains(ch) && !setSub[(i/3) * 3 + j/3].contains(ch)) {
                setRow[i].add(ch);
                setCol[j].add(ch);
                setSub[(i/3) * 3 + j/3].add(ch);
                board[i][j] = ch;
                if(dfs(num+1, board, setRow, setCol, setSub))  // 向下递归
                    return true;
                setRow[i].remove(ch);
                setCol[j].remove(ch);
                setSub[(i/3) * 3 + j/3].remove(ch);
                board[i][j] = '.';
            }
        }
        return false;  // 如果一个合格的都没有，就返回false
    }
}

