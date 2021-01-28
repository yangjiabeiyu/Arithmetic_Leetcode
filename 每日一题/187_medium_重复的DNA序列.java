/*
187. 重复的DNA序列
所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
https://leetcode-cn.com/problems/repeated-dna-sequences/
编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

示例 1：
输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
示例 2：
输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]
*/

/*
解法：用hashmap记录出现的字符串及次数
执行用时：24 ms, 在所有 Java 提交中击败了39.59%的用户
内存消耗：47.2 MB, 在所有 Java 提交中击败了29.12%的用户
*/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) return new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        int n = s.length() - 10;
        for(int i = 0; i <= n; i++) {
            String temp = s.substring(i, i + 10);
            if(map.containsKey(temp) && map.get(temp) == 1) {
                res.add(temp);
                map.put(temp, 2);
            }
            else if(!map.containsKey(temp))
                map.put(temp, 1);
        }
        return res;
    }
}

