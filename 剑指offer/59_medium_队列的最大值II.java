/*
剑指 Offer 59 - II. 队列的最大值
https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]

示例 2：
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
*/

/*
解法：构造一个正常队列；然后有一个辅助的单调队列，递减。新来的元素，只需要和队列尾部比较，更大则队列尾部出队，继续比较，维持单调队列。
执行用时：38 ms, 在所有 Java 提交中击败了58.15% 的用户
内存消耗：46.3 MB, 在所有 Java 提交中击败了92.78% 的用户
*/
class MaxQueue {
    Deque<Integer> A, B;

    public MaxQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }
    
    public int max_value() {
        if(B.isEmpty())
            return -1;
        return B.peekFirst();     // 辅助队列的队首元素
    }
    
    public void push_back(int value) {
        A.offerLast(value);
        while(!B.isEmpty() && B.peekLast() < value)   // 从队列尾部开始比较
            B.pollLast();
        B.offerLast(value);
    }
    
    public int pop_front() {
        if(A.isEmpty())
            return -1;
        int num = A.pollFirst();
        if(num == B.peekFirst())     // 如果最大值出队了，也让辅助队列的最大值出队
            B.pollFirst();
        return num;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

