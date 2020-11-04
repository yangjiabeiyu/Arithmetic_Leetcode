/*
240. 搜索二维矩阵 II
https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
    每行的元素从左到右升序排列。
    每列的元素从上到下升序排列。

示例:
现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

给定 target = 5，返回 true。
给定 target = 20，返回 false。
*/

/*
解法：从左上角开始找，如果比target大，就往左走；小，就往下走。
执行用时：5 ms, 在所有 Java 提交中击败了99.80% 的用户
内存消耗：44.2 MB, 在所有 Java 提交中击败了52.48% 的用户
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int m = 0, n = matrix[0].length - 1;
        while(m < matrix.length && n >= 0) {
            if(matrix[m][n] > target)
                n--;
            else if(matrix[m][n] < target)
                m++;
            else
                return true;
        }
        return false;
            
    }
}


