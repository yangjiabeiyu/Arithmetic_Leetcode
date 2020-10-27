/*
剑指 Offer 04. 二维数组中的查找
https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

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
解法：从右上角或者左下角开始寻找。以右上角为例，如果target小，那么就向左走，因为下面相比着会更小；如果target大，那么就向下走。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：44 MB, 在所有 Java 提交中击败了94.65% 的用户
*/
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] > target)
                col--;
            else if(matrix[row][col] < target)
                row++;
            else
                return true;
        }
        return false;
    }
}


