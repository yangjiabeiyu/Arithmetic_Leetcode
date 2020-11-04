/*
22. 括号生成
https://leetcode-cn.com/problems/generate-parentheses/
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
*/

/*
解法：回溯
*/
class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(n, n);
        return res;
    }
    public void dfs(int n1, int n2) {
        if(n1 == 0 && n2 == 0) {
            res.add(path.toString());
            return;
        }
        if(n1 > 0) {
            path.append('(');
            dfs(n1 - 1, n2);
            path.deleteCharAt(path.length() - 1);
        }
        if(n1 < n2) {
            path.append(')');
            dfs(n1, n2 - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

