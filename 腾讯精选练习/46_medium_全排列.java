/*
46. 全排列
https://leetcode-cn.com/problems/permutations/
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

/*
解法：回溯
执行用时：1 ms, 在所有 Java 提交中击败了99.59% 的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了46.70% 的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        for(int i = 0; i < nums.length; i++)     // 先把数字放到列表中，这一步主要是int数组难以转为列表……
            path.add(nums[i]);
        dfs(0);
        return res;
    }
    public void dfs(int n) {
        if(n == path.size() - 1) {    // 到了最后一个，没有选择的余地，就直接加入res，注意要新建list
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = n; i < path.size(); i++) {
            swap(path, n, i);   // 交换位置
            dfs(n + 1);  // 进入下一层
            swap(path, n, i);  // 撤回操作
        }
    }
    public void swap(List<Integer> path, int left, int right) {   // 交换列表中两元素的位置
        int temp = path.get(left);
        path.set(left, path.get(right));
        path.set(right, temp);
    }
}



