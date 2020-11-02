/*
78. 子集
https://leetcode-cn.com/problems/subsets/
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/*
解法一：回溯
执行用时：1 ms, 在所有 Java 提交中击败了99.35% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了88.71% 的用户
*/
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums, int n) {
        res.add(new ArrayList<Integer>(path));   // 添加path，但要新建，否则后续增删会改变已加入的值
        for(int i = n; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

/*
解法二：递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了86.80% 的用户
*/
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    public void dfs(int[] nums, int n) {
        if(n == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(nums[n]);    // 选择nums[n]
        dfs(nums, n + 1);
        path.remove(path.size() - 1);  // 不选择nums[n]
        dfs(nums, n + 1);
    }
}


