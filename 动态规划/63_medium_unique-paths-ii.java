/*
不同路径II
https://leetcode.com/problems/unique-paths-ii/
题目描述
一个机器人位于一个 m x n 网格的左上角。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？网格中的障碍物和空位置分别用 1 和 0 来表示。
示例
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
*/

/*
解法：障碍物对应位置，路径数为0，其余计算与62题相同
执行用时：1 ms, 在所有 Java 提交中击败了30.41% 的用户
内存消耗：36.8 MB, 在所有 Java 提交中击败了90.41% 的用户
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        // 初始化
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                for(int j = i; j < m; j++)  //该循环可以省略，直接break，因为本身默认值就是0
                    res[j][0] = 0;
                break;
            }
            else
                res[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                for(int j = i; j < n; j++)  //该循环可以省略，直接break，因为本身默认值就是0
                    res[0][j] = 0;
                break;
            }
            else
                res[0][i] = 1;
        }
        // 迭代
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    res[i][j] = 0;
                else
                    res[i][j] = res[i-1][j] + res[i][j-1];
            }
        return res[m-1][n-1];
    }
}

/*
空间优化：同样只需要一个数组，但需要注意的是，在62题中，res[0]一直都是1；如果在第一列出现了障碍物，对于的res[0]就是0，就不是1了。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.9 MB, 在所有 Java 提交中击败了82.28% 的用户
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] res = new int[n];
        // 初始化，一旦遇到障碍物，就保持初始默认值0
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 0)
                res[i] = 1;
            else
                break;
        }
        for(int i = 1; i < m; i++) {
            if(obstacleGrid[i][0] == 1)  // 如果第一列有障碍物，那么后续res的第一项均为0
                res[0] = 0;      
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    res[j] = 0;
                else
                    res[j] += res[j-1];
            }
        }
        return res[n-1];
    }
}

/*
优化二：多开辟一个空间，无需判断边界
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.8 MB, 在所有 Java 提交中击败了90.09% 的用户
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] res = new int[n + 1];
        // 初始化
        res[1] = 1;  // 默认没有障碍物，有初始值1；一旦遇到障碍物 ，那么res[1]就变为0
        for(int i = 1; i <= m; i++) {   
            for(int j = 1; j <= n; j++) {
                if(obstacleGrid[i - 1][j - 1] == 1)
                    res[j] = 0;
                else
                    res[j] += res[j-1];
            }
        }
        return res[n];
    }
}

/*
不多一个空间开辟，需要判断边界
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.1 MB, 在所有 Java 提交中击败了72.16% 的用户
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] res = new int[n];
        // 初始化
        res[0] = 1;
        for(int i = 0; i < m; i++) {   
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1)
                    res[j] = 0;
                else if(j > 0)
                    res[j] += res[j-1];
            }
        }
        return res[n - 1];
    }
}
