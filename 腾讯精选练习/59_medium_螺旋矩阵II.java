/*
59. 螺旋矩阵 II
https://leetcode-cn.com/problems/spiral-matrix-ii/
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

/*
解法：和螺旋矩阵一样的思路。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了90.21% 的用户
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while(true) {          // 限制条件也可以是num <= n * n，后续就不用一直判断break。
            for(int i = left; i <= right; i++)
                res[top][i] = num++;
            if(++top > bottom) break;
            for(int i = top; i <= bottom; i++)
                res[i][right] = num++;
            if(--right < left) break;
            for(int i = right; i >= left; i--)
                res[bottom][i] = num++;
            if(--bottom < top) break;
            for(int i = bottom; i >= top; i--)
                res[i][left] = num++;
            if(++left > right) break;
        }
        return res;
    }
}
