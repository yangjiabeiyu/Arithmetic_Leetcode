/*
316. 去除重复字母
https://leetcode-cn.com/problems/remove-duplicate-letters/
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

示例 1：
输入：s = "bcabc"
输出："abc"

示例 2：
输入：s = "cbacdcbc"
输出："acdb"
*/

/*
执行用时：3 ms, 在所有 Java 提交中击败了97.17% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了72.23% 的用户
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] exist = new boolean[26];  // 判断stack中是否含有字符
        char[] chs = s.toCharArray();
        for(char ch : chs)     // 统计字符出现的次数
            count[ch - 'a']++;
        Stack<Character> stack = new Stack<>();
        for(char ch : chs) {
            if(!exist[ch - 'a']) {  // 如果stack中不含待处理字符，则需要加进来；若包含，则不加
                while(!stack.isEmpty() && count[stack.peek()-'a'] > 0 && stack.peek() > ch)  // 如果栈不为空、栈顶元素后续还有、栈顶元素比待处理元素大，那么就可以把栈顶元素弹出，反正后面还有
                    exist[stack.pop() - 'a'] = false;   // 更新栈中元素存在情况
                stack.push(ch);  // 把待处理元素压栈
                exist[ch - 'a'] = true;  // 栈内存在待处理字符
            }
            count[ch - 'a']--;   // 次数减1
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
            res.append(stack.pop());
        return res.reverse().toString();  // 倒序
    }
}

