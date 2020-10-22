/*
剑指 Offer 31. 栈的压入、弹出序列

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

示例 1：
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

示例 2：
输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
*/

/*
解法：模拟栈的压栈与弹栈
执行用时：2 ms, 在所有 Java 提交中击败了96.72% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了98.73% 的用户
*/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num);               // 压栈
            while(!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]) {        // 如果栈内元素与popped相同，就弹栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();          // 判断栈是否为空
    }
}

