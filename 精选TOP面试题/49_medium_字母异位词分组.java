/*
49. 字母异位词分组
https://leetcode-cn.com/problems/group-anagrams/
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
*/

/*
解法：建立map，排序的字符串-->不同的异位词列表。相当于提取出来异位词组的共同特征，即排序后的字符串相同。
执行用时：9 ms, 在所有 Java 提交中击败了62.60% 的用户
内存消耗：41.7 MB, 在所有 Java 提交中击败了57.28% 的用户
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);     // 先对数组排序
            String s = String.valueOf(ch);   // 转为字符串
            if(!map.containsKey(s))      // 如果map不包含，就放入
                map.put(s, new ArrayList<String>());
            map.get(s).add(str);     // 把str放入
        }
        return new ArrayList<>(map.values());   // 得到结果
    }
}


