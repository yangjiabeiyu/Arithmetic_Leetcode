/*
47. 全排列 II
https://leetcode-cn.com/problems/permutations-ii/
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

/*
解法：回溯
执行用时：2 ms, 在所有 Java 提交中击败了66.43% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了89.09% 的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            path.add(nums[i]);
        dfs(0);
        return res;
    }
    public void dfs(int k) {
        if(k == path.size() - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = k; i < path.size(); i++) {  // 注意这里是用path，而不是nums
            if(set.add(path.get(i))) {
                swap(k, i);
                dfs(k + 1);
                swap(k, i);
            }
        }
    }
    public void swap(int left, int right) {
        int temp = path.get(left);
        path.set(left, path.get(right));
        path.set(right, temp);
    }
}

