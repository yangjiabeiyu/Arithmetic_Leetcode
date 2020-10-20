/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法：dfs，使用二维数组记录是否已经访问过。
执行用时：1 ms, 在所有 Java 提交中击败了85.36% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了76.47% 的用户
*/

class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        return movingCount(map, m, n, 0, 0, k);
    }
    public int movingCount(int[][] map, int m, int n, int row, int col, int k) {
        if(row < 0 || row >= m || col < 0 || col >= n || map[row][col] == 1 || sumNum(row) + sumNum(col) > k)
            return 0;
        map[row][col] = 1;     // 访问过的位置置为1
        int sum = 0;
        sum = 1 + movingCount(map, m, n, row + 1, col, k)
                + movingCount(map, m, n, row - 1, col, k)
                + movingCount(map, m, n, row, col + 1, k)
                + movingCount(map, m, n, row, col - 1, k);
        return sum;
    }
    public int sumNum(int n) {       // 计算各位加和   
        int res = 0;
        while(n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}


/*
优化：只需要向下或者向右搜索
执行用时：1 ms, 在所有 Java 提交中击败了85.36% 的用户
内存消耗：34.8 MB, 在所有 Java 提交中击败了99.99% 的用户
*/
class Solution {
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        return movingCount(map, m, n, 0, 0, k);
    }
    public int movingCount(int[][] map, int m, int n, int row, int col, int k) {
        if(row < 0 || row >= m || col < 0 || col >= n || map[row][col] == 1 || sumNum(row) + sumNum(col) > k)
            return 0;
        map[row][col] = 1;
        return 1 + movingCount(map, m, n, row + 1, col, k)
                 + movingCount(map, m, n, row, col + 1, k);
    }
    public int sumNum(int n) {
        int res = 0;
        while(n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}


