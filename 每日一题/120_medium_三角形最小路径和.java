/*
120. 三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。
https://leetcode-cn.com/problems/triangle/
每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

示例 1：
输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
输出：11
解释：如下面简图所示：
   2
  3 4
 6 5 7
4 1 8 3
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
示例 2：

输入：triangle = [[-10]]
输出：-10
*/

/*
解法一：dp即可
执行用时：5 ms, 在所有 Java 提交中击败了21.56%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了37.14%的用户
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return 0;
        List<Integer> dis = triangle.get(0);
        for(int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> dis_new = new ArrayList<>();
            dis_new.add(list.get(0) + dis.get(0));   // 第一个
            for(int j = 1; j < i; j++)  // 中间的
                dis_new.add(Math.min(dis.get(j), dis.get(j - 1)) + list.get(j));
            dis_new.add(list.get(i) + dis.get(i - 1));  // 最后一个
            dis = dis_new;  // 更新
        }
        int res = dis.get(0);
        for(int i = 1; i < n; i++)
            res = Math.min(res, dis.get(i));
        return res;
    }
}

/*
解法二：用数组代替解法一中的list
执行用时：2 ms, 在所有 Java 提交中击败了92.82%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了49.67%的用户
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dis = new int[n];
        dis[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            int[] dis_new = new int[n];
            dis_new[0] = dis[0] + list.get(0);
            for(int j = 1; j < i; j++)
                dis_new[j] = Math.min(dis[j], dis[j - 1]) + list.get(j);
            dis_new[i] = dis[i - 1] + list.get(i);
            dis = dis_new;
        }
        int res = dis[0];
        for(int i = 1; i < n; i++)
            res = Math.min(res, dis[i]);
        return res;
    }
}

/*
解法三：逆向更新可以只用一个一维数组
执行用时：2 ms, 在所有 Java 提交中击败了92.82%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了41.14%的用户
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dis = new int[n];
        dis[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            dis[i] = dis[i - 1] + list.get(i);
            for(int j = i - 1; j > 0; j--)
                dis[j] = Math.min(dis[j], dis[j - 1]) + list.get(j);
            dis[0] = dis[0] + list.get(0);
        }
        int res = dis[0];
        for(int i = 1; i < n; i++)
            res = Math.min(res, dis[i]);
        return res;
    }
}

/*
解法四：可以从下往上进行更新
执行用时：2 ms, 在所有 Java 提交中击败了92.82%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了61.33%的用户
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dis = new int[n + 1];  // 便于处理边界
        for(int i = n - 1; i >= 0; --i) {
            List<Integer> list = triangle.get(i);
            for(int j = 0; j <= i; ++j)
                dis[j] = Math.min(dis[j], dis[j + 1]) + list.get(j);  // 向上走的时候，需要正向遍历，因为每次用到的是后面的值
        }
        return dis[0];
    }
}

