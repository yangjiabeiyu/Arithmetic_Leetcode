/*
剑指 Offer 29. 顺时针打印矩阵
https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
*/

/*
解法：模拟过程，设置上下左右四个边界，不断缩小。
执行用时：1 ms, 在所有 Java 提交中击败了96.75% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了99.50% 的用户
*/
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, cnt = 0;
        while(true) {
            for(int i = left; i <= right; i++)
                res[cnt++] = matrix[top][i];            // 左到右
            if(++top > bottom)
                break;
            for(int i = top; i <= bottom; i++)
                res[cnt++] = matrix[i][right];          // 上到下
            if(--right < left)
                break;
            for(int i = right; i >= left; i--)
                res[cnt++] = matrix[bottom][i];         // 右到左
            if(--bottom < top)
                break;
            for(int i = bottom; i >= top; i--)
                res[cnt++] = matrix[i][left];           // 下到上
            if(++left > right)
                break;
        }
        return res;
    }
}

