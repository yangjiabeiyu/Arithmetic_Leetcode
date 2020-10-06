/*
不同路径
https://leetcode.com/problems/unique-paths/
题目描述
一个机器人位于一个 m x n 网格的左上角。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
示例
输入: m = 3, n = 2    输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
*/

/*
解法：动态规划，创建二维数组res，对应着每个方格，意义是到达该方格的路径数；那么有res[i][j] = res[i-1][j] + res[i][j-1]。
初始值为i = 0，或j = 0时，对应的路径数都为1（res[0][0]除外，可不作讨论）。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.6 MB, 在所有 Java 提交中击败了43.34% 的用户
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        int[][] res = new int[m][n];
        // 初始化
        for(int i = 1; i < m; i++)
            res[i][0] = 1;
        for(int i = 1; i < n; i++)
            res[0][i] = 1;
        // 迭代
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                res[i][j] = res[i-1][j] + res[i][j-1];
        return res[m-1][n-1];
    }
}

/*
空间优化：迭代计算，在计算过程中，仅需要当前行与上一行的数据，所以只需要两个数组不断迭代；再次优化则是可以在一个数组中不断更新迭代：
res[i] = res[i] + res[i-1]，右式中的res[i]表示上一行的i处，res[i-1]则表示当前行的i-1处。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.3 MB, 在所有 Java 提交中击败了93.38% 的用户
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        Arrays.fill(res, 1);  // 初始化
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++)
                res[j] += res[j-1];
        }
        return res[n-1];
    }
}
