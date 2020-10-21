/*
剑指 Offer 09. 用两个栈实现队列

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
*/

/*
解法一：两个栈，一个负责插入，一个负责删除。如果删除栈为空，就让插入栈谈到删除栈。
执行用时：56 ms, 在所有 Java 提交中击败了65.46% 的用户
内存消耗：46.8 MB, 在所有 Java 提交中击败了56.14% 的用户
*/
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);                   // 插入栈
    }
    
    public int deleteHead() {
        if(!stack2.isEmpty())
            return stack2.pop();              // 删除栈不为空，就弹出
        if(stack1.isEmpty())                  // 如果插入栈也没元素，就返回-1
            return -1;
        while(!stack1.isEmpty())              // 移到删除栈
            stack2.push(stack1.pop());  
        return stack2.pop();                  // 删除元素
    }
}


