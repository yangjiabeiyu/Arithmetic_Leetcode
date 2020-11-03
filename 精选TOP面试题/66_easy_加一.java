/*
66. 加一
https://leetcode-cn.com/problems/plus-one/
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/

/*
解法：其实问题不难，但细节其实很巧妙。对于初始，如果中间没有9，那么就不用考虑了，加上1直接返回；
如果一直不中断，那说明就是999……，加上1，就是1000……，所以只需要新建一个数组，首位置1即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37 MB, 在所有 Java 提交中击败了84.05% 的用户
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0)
                return digits;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}

