/*
48. 旋转图像
https://leetcode-cn.com/problems/rotate-image/
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。

说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*/
/*
解法一：外圈到内圈，逐层旋转
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了80.71% 的用户
*/
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int n = matrix.length - 1, m = n / 2;
        for(int i = 0; i <= m; i++) {
            for(int j = i; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }
}

/*
解法二：先转置，然后逐行进行翻转
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了87.07% 的用户
*/
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int n = matrix.length - 1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i <= n; i++) {
            int left = 0, right = n;
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}



