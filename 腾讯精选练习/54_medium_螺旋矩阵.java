/*
54. 螺旋矩阵
https://leetcode-cn.com/problems/spiral-matrix/
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]

示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

/*
解法：模仿矩阵收缩
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.6 MB, 在所有 Java 提交中击败了71.20% 的用户
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList();
        List<Integer> list = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while(true) {
            for(int i = left; i <= right; i++)
                list.add(matrix[top][i]);
            if(++top > bottom) break;
            for(int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            if(--right < left) break;
            for(int i = right; i >= left; i--)
                list.add(matrix[bottom][i]);
            if(--bottom < top) break;
            for(int i = bottom; i >= top; i--)
                list.add(matrix[i][left]);
            if(++left > right) break;
        }
        return list;
    }
}


