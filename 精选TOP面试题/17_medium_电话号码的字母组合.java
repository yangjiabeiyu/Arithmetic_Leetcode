/*
17. 电话号码的字母组合
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
*/

/*
解法：回溯
执行用时：1 ms, 在所有 Java 提交中击败了86.72% 的用户
内存消耗：37.3 MB, 在所有 Java 提交中击败了90.38% 的用户
*/
class Solution {
    List<String> res = new ArrayList<>();        // 存储结果
    StringBuilder path = new StringBuilder();    // 存储路径值
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        Map<Character, String> map = new HashMap<>();
        initialize(map);
        dfs(digits, 0, map);
        return res;
    }
    public void dfs(String digits, int index, Map<Character, String> map) {
        if(index == digits.length()) {
            res.add(path.toString());
            return;
        }
        String digit = map.get(digits.charAt(index));
        for(int i = 0; i < digit.length(); i++) {
            path.append(digit.charAt(i));
            dfs(digits, index + 1, map);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public void initialize(Map map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}

