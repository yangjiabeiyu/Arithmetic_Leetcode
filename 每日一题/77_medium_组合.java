/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
https://leetcode-cn.com/problems/combinations/
示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

/*
解法一：回溯
执行用时：19 ms, 在所有 Java 提交中击败了54.87%的用户
内存消耗：40 MB, 在所有 Java 提交中击败了19.42%的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k);
        return res;
    }
    public void dfs(int n, int index, int k) {  // index表示到达了哪个数字，k表示还剩几个数字
        if(k == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = index; i <= n; i++) {
            path.add(i);   // 加入一个新的
            dfs(n, i + 1, k - 1);
            path.remove(path.size() - 1);  // 删除末尾
        }
    }
}

/*
解法一的剪枝
执行用时：2 ms, 在所有 Java 提交中击败了92.98%的用户
内存消耗：40 MB, 在所有 Java 提交中击败了18.40%的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k);
        return res;
    }
    public void dfs(int n, int index, int k) {  // index表示到达了哪个数字，k表示还剩几个数字
        if(k == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = index; i <= n - k + 1; i++) {   // 这里也是要减去数字不够的情况
            path.add(i);   // 加入一个新的
            dfs(n, i + 1, k - 1);
            path.remove(path.size() - 1);  // 删除末尾
        }
    }
}

/*
解法二：递归，主要思路就是加入，不加入
执行用时：19 ms, 在所有 Java 提交中击败了54.87%的用户
内存消耗：40 MB, 在所有 Java 提交中击败了20.26%的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k);
        return res;
    }
    public void dfs(int n, int index, int k) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if(index > n) return;
        path.add(index);
        dfs(n, index + 1, k - 1);
        path.remove(path.size() - 1);
        dfs(n, index + 1, k);
    }
}

/*
解法二的剪枝
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了37.59%的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k);
        return res;
    }
    public void dfs(int n, int index, int k) {
        if(n - index + 1 < k)  // 如果剩下的数不够k个了，那就停止
            return;
        if(k == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if(index > n) return;
        path.add(index);
        dfs(n, index + 1, k - 1);
        path.remove(path.size() - 1);
        dfs(n, index + 1, k);
    }
}

