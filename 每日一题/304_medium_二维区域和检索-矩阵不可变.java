/*
304. 二维区域和检索 - 矩阵不可变
https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
Range Sum Query 2D
上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

示例:
给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
*/

/*
执行用时：14 ms, 在所有 Java 提交中击败了97.93% 的用户
内存消耗：44 MB, 在所有 Java 提交中击败了71.63% 的用户
*/
class NumMatrix {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m != 0) {
            int n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++)
                for(int j = 1; j <= n; j++)
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}

