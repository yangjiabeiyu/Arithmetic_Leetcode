/*
Z字形变换
https://leetcode-cn.com/problems/zigzag-conversion/
题目描述
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
*/

/*
解法一：逐行读取，对于每一行，遍历字符串获取位于该行的元素:
位于第0行的元素，在字符串中的下标为 k*(2*(numRows-1))
位于第numRows-1行的元素，在字符串中的下标为 k*(2*(numRows-1)) + numRows - 1
位于第i行的元素，在字符串中的下标为 k*(2*(numRows-1)) + i 和 k*(2*(numRows-1)) + i + 2*(numRows-1-i)
*/

// 我的初次解法，整体思想是逐行读取，对于中间行，需要有一来一回的两个gap
// 执行用时：19 ms, 在所有 Java 提交中击败了20.83% 的用户
// 内存消耗：39.6 MB, 在所有 Java 提交中击败了21.44% 的用户
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(n <= 1 || numRows == 1)
            return s;
        String ans = "";
        for(int i = 0; i < numRows; i++) {
            if(i < n)
                ans += s.charAt(i);   // 先找到第一个
            int gap1 = 2 * i, gap2 = 2 * (numRows - i - 1), start = i;
            while(true) {
                if(start + gap2 >= n)
                    break;
                if(gap2 != 0)  // 如果gap是0，那么不能重复读取，这里主要针对第一行和最后一行，一来一回仅有一个
                    ans += s.charAt(start += gap2);
                if(start + gap1 >= n)
                    break;
                if(gap1 != 0)
                    ans += s.charAt(start += gap1);
            }  
        }
        return ans;
    }
}

// 参考答案后的解法，这里的思路更好，相当于每次一来一回先找一个，然后如果是中间行，那么就再找下一个
// 执行用时：20 ms, 在所有 Java 提交中击败了18.32% 的用户
// 内存消耗：39.9 MB, 在所有 Java 提交中击败了9.50% 的用户
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int n = s.length(), gap = 2 * (numRows - 1);
        String ans = "";
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j + i < n; j += gap) {
                ans += s.charAt(j + i);
                if(i != 0 && i != numRows - 1 && j + gap - i < n)
                    ans += s.charAt(j + gap - i);
            }
        }
        return ans;
    }
}

/*
解法二：遍历字符串，判断元素应在哪一行，每一行设置一个StringBuilder添加元素，最后综合所有的StringBuilder
执行用时：12 ms, 在所有 Java 提交中击败了31.67% 的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了21.98% 的用户
*/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < Math.min(s.length(), numRows); i++)  //每行设置一个容器
            list.add(new StringBuilder());
        String ans = "";
        boolean dir = false;
        int curRow = 0;
        for(int i = 0; i < s.length(); i++) {
            list.get(curRow).append(s.charAt(i));
            if(curRow == 0 || curRow == numRows - 1)  // 如果到了首行和尾行，变向
                dir = !dir;
            curRow += dir ? 1 : -1;
        }
        for(StringBuilder str : list)  // 综合所有的builder
            ans += str.toString();
        return ans;
    }
}
