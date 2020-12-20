/*
241. 为运算表达式设计优先级

给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:
输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2

示例 2:
输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/

/*
执行用时：2 ms, 在所有 Java 提交中击败了72.11% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了68.41% 的用户
*/
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));   // 获得左侧的结果
                List<Integer> rightRes = diffWaysToCompute(input.substring(i + 1));   // 获得右侧的结果
                for(int left : leftRes)    // 逐个计算出来结果，加入到res中
                    for(int right : rightRes) {
                        if(ch == '+')
                            res.add(left + right);
                        else if(ch == '-')
                            res.add(left - right);
                        else
                            res.add(left * right);
                    }
            }
        }
        if(res.size() == 0)       // 如果size为0，说明input是个数字，不含运算符
            res.add(Integer.valueOf(input));
        return res;
    }
}

