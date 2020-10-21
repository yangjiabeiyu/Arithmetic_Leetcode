/*
剑指 Offer 58 - I. 翻转单词顺序

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

示例 2：
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

说明：
    无空格字符构成一个单词。
    输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
*/

/*
解法一：顺序查找，然后将单词放到栈中，然后弹栈。
执行用时：10 ms, 在所有 Java 提交中击败了12.96% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了98.19% 的用户
*/
class Solution {
    public String reverseWords(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        boolean flag = true;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                continue;
            StringBuilder str = new StringBuilder();
            while(i < s.length() && s.charAt(i) != ' ') {           // 加单词
                str.append(s.charAt(i));
                i++;
            }
            stack.push(str);                                       // 单词进栈
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.append(stack.pop());
            if(stack.size() > 0)
                res.append(' ');
        }
        return res.toString();
    }
}


/*
解法二：设置两个尾指针，然后前移，一个放在单词右端，另外一个找左端。
执行用时：4 ms, 在所有 Java 提交中击败了42.62% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了94.53% 的用户
*/
class Solution {
    public String reverseWords(String s) {
        s.trim();
        int p = s.length() - 1, q = p;
        StringBuilder res = new StringBuilder();
        while(p >= 0) {
            while(p >= 0 && s.charAt(p) != ' ')             // 找左端点
                p--;
            res.append(s.substring(p + 1, q + 1) + " ");
            while(p >= 0 && s.charAt(p) == ' ')             // 找新的右端点
                p--;
            q = p;
        }
        return res.toString().trim();                       // 删除末尾的空格
    }
}


