/*
剑指 Offer 30. 包含min函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.

提示：
    各函数的调用总次数不超过 20000 次
*/

/*
解法：构造一个正常栈和单调辅助栈，如果新元素不大于辅助栈顶，就压栈；在pop时，如果两个栈的栈顶元素相等，就都弹栈。
执行用时：22 ms, 在所有 Java 提交中击败了28.56% 的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了91.98% 的用户
*/
class MinStack {
    Stack<Integer> A, B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack<>();   // 正常栈
        B = new Stack<>();   // 辅助栈
    }
    
    public void push(int x) {
        A.push(x);
        if(B.isEmpty() || B.peek() >= x)   // 注意是≥
            B.push(x);
    }
    
    public void pop() {
        if(B.peek().equals(A.pop()))   // 这里注意，直接==对于[-128~127]的数字是没问题的，但再大，就会比较对象地址，所以需要注意一下。
            B.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int min() {
        return B.peek();
    }
}


