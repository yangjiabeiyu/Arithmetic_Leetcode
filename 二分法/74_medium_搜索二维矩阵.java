/*
74. 搜索二维矩阵
https://leetcode-cn.com/problems/search-a-2d-matrix/
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    每行中的整数从左到右按升序排列。
    每行的第一个整数大于前一行的最后一个整数。

示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
输出：true
*/

/*
解法：先找行后找列
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了74.84% 的用户
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int mTop = 0, mBottom = matrix.length - 1, row = 0;     // 用row记录一下行
        while(mTop <= mBottom) {
            int mid = mTop + (mBottom - mTop) / 2;
            if(matrix[mid][0] < target) {
                row = mid;
                mTop = mid + 1;
            }
            else if(matrix[mid][0] > target)
                mBottom = mid - 1;
            else
                return true;
        }
        int mLeft = 0, mRight = matrix[0].length - 1;
        while(mLeft <= mRight) {
            int mid = mLeft + (mRight - mLeft) / 2;
            if(matrix[row][mid] > target)
                mRight = mid - 1;
            else if(matrix[row][mid] < target)
                mLeft = mid + 1;
            else
                return true;
        }
        return false;
    }
}

/*
解法二：直接展开，用m*n-1作为right，然后求出mid后再映射到矩阵中
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了86.25% 的用户
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length, left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid / n][mid % n] > target)
                right = mid - 1;
            else if(matrix[mid / n][mid % n] < target)
                left = mid + 1;
            else
                return true;
        }
        return false;
    }
}

