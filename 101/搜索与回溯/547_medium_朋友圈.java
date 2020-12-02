/*
547. 朋友圈
https://leetcode-cn.com/problems/friend-circles/
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1：
输入：
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出：2 
解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回 2 。
*/

/*
解法一：其实本题是有n个节点，然后邻居有n-1个，这样遍历就行
执行用时：8 ms, 在所有 Java 提交中击败了13.61% 的用户
内存消耗：40.1 MB, 在所有 Java 提交中击败了5.05% 的用户
*/
class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        for(int i = 0; i < M.length; i++)
            if(M[i][i] == 1) {   // 如果对角线上为1，说明它还没遍历到
                dfs(M, i);
                res++;
            }
        return res;
    }
    public void dfs(int[][] M, int m) {
        if(m < 0 || m >= M.length)
            return;
        M[m][m] = 0;
        for(int i = 0; i < M.length; i++)
            if(M[m][i] == 1) {
                M[m][i] = 0;    // 得置0，表示已经见过
                dfs(M, i);
            }     
    }
}

/*
解法二：在解法一的基础上，可以使用一个数组，记录节点是否被遍历到，这样就可以避免————从a遍历到b，从b遍历到c，而c又会判断与a的相遇。
执行用时：1 ms, 在所有 Java 提交中击败了99.89% 的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了61.71% 的用户
*/
class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++)
            if(!visited[i]) {     // 这个判断是否遍历到，也可以放到dfs方法的判断中
                dfs(M, i, visited);
                res++;
            }
        return res;
    }
    public void dfs(int[][] M, int m, boolean[] visited) {
        if(m < 0 || m >= M.length)
            return;
        visited[m] = true;
        for(int i = 0; i < M.length; i++)
            if(!visited[i] && M[m][i] == 1)   // 如果没遍历到i，而且与i有关系，就向下搜
                dfs(M, i, visited);
    }
}

