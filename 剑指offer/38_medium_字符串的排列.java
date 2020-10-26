/*
剑指 Offer 38. 字符串的排列
https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
*/

/*
解法：递归回溯，主要思路是逐个与当前元素交换。
执行用时：8 ms, 在所有 Java 提交中击败了98.33% 的用户
内存消耗：42.5 MB, 在所有 Java 提交中击败了98.96% 的用户
*/
class Solution {
    List<String> res = new ArrayList<>();   // 记录结果
    public String[] permutation(String s) {
        char[] c = s.toCharArray();       // 先将字符串转为字符数组，后续用于交换
        dfs(c, 0);
        return res.toArray(new String[res.size()]);   // 列表转为字符串数组
    }
    public void dfs(char[] c, int pos) {
        if(pos == c.length - 1) {              // 如果到了末尾，也就没有其余可能性，就直接把字符数组转为字符串，加入到列表中
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();      // 建立哈希表，主要是防止当前元素相同
        for(int i = pos; i < c.length; i++) {
            if(set.contains(c[i]))
                continue;
            set.add(c[i]);         // 放入哈希表
            swap(c, i, pos);       // 更换位置，对于初始的i=pos，其实是先固定当前字符
            dfs(c, pos + 1);       // 深度搜索
            swap(c, i, pos);       // 更换回来
        }
    }
    public void swap(char[] c, int left, int right) {
        char temp = c[right];
        c[right] = c[left];
        c[left] = temp;
    }
}

