/*
76. 最小覆盖子串
https://leetcode-cn.com/problems/minimum-window-substring/
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"

示例 2：
输入：s = "a", t = "a"
输出："a"
*/

/*
解法：使用hashmap记录t中的字符及其出现次数；双指针，先找到包含t的区间，然后尝试将左端点右移，缩小区间如果包含t，那么就找到了更优解。
执行用时：12 ms, 在所有 Java 提交中击败了63.12% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了80.66% 的用户
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);       // 记录t的字符及其次数
        int left = 0;
        while(left < s.length() && !map.containsKey(s.charAt(left)))          // 从处于t中字符开始
            left++;
        int cnt = 0, n = t.length(), minLeft = left, minLen = s.length() + 1;  // cnt表示当前区间，包含t中字符的个数；minLen设置为最大长度加1可以区分是否有解
        for(int right = left; right < s.length(); right++) {        // 遍历右端点
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {        // 如果右端点处的字符在t中
                int num = map.get(ch);       // 看map中的次数
                if(num > 0) cnt++;           // 如果该字符次数仍大于0，则将cnt加1，表示又纳入了新的字符，并刷新map
                map.put(ch, num - 1);
                while(cnt == n) {            // 如果区间包含了t，就尝试从左侧缩小区间
                    char chL = s.charAt(left);   // 左侧字符
                    if(right - left + 1 < minLen) {   // 先刷新最优解
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if(map.containsKey(chL)) {     // 如果左侧字符在map中
                        int num2 = map.get(chL);   // 检查其次数，如果不小于0，说明left右滑会导致区间不包括所有的t，将cnt-1，并刷新map
                        if(num2 >= 0) cnt--;
                        map.put(chL, num2 + 1);
                    }
                    ++left;   // 压缩区间
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(minLeft, minLeft + minLen);
    }
}

