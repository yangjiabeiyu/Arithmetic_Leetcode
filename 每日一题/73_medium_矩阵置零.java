/*
73. 矩阵置零
https://leetcode-cn.com/problems/set-matrix-zeroes/
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:
输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
*/

/*
解法一：记录下来应置为0的行号和列号
执行用时：2 ms, 在所有 Java 提交中击败了42.64% 的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了80.69% 的用户
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> setRow = new HashSet<>();
        Set<Integer> setCol = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        for(int i : setRow)   // 这里两种思路，也可以遍历数组，看看元素的行或者列在不在两个集合中，若在则置0
            for(int k = 0; k < n; k++)
                matrix[i][k] = 0;
        for(int j : setCol)
            for(int k = 0; k < m; k++)
                matrix[k][j] = 0;
    }
}

/*
解法二：将第一行和第一列作为标志位，如果需要置0就先置为0，最后再一并处理；
matrix[0][0]只能管控一个，这里让其代表第一行的情况，然后再单独设置一个标志位，代表第一列的情况。
执行用时：1 ms, 在所有 Java 提交中击败了99.85% 的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了42.44% 的用户
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        boolean flag = false;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0)
                flag = true;
            for(int j = 1; j < n; j++)
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 1; j--)
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if(flag) matrix[i][0] = 0;  // 注意这里，只有后面的都判断完了，才可以处理标志位的情况
        }
    }
}

