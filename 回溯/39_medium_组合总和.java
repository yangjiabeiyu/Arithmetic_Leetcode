/*
39. 组合总和

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 

示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]

示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

/*
解法一：回溯，主要是回溯入口得写法
执行用时：4 ms, 在所有 Java 提交中击败了54.06% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了92.82% 的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }
    public void dfs(int[] candidates, int target, int index) {
        if(target < 0 || index == candidates.length)
            return;
        if(target == 0)
            res.add(new ArrayList(path));
        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}

/*
解法二：剪枝，排完序，如果target已经＜0，就不用继续了
执行用时：2 ms, 在所有 Java 提交中击败了99.93% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了94.81% 的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }
    public void dfs(int[] candidates, int target, int index) {
        if(target == 0)
            res.add(new ArrayList(path));
        for(int i = index; i < candidates.length; i++) {
            if(target - candidates[i] < 0) break;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}

