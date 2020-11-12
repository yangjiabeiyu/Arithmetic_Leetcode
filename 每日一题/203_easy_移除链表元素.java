/*
203. 移除链表元素
https://leetcode-cn.com/problems/remove-linked-list-elements/
删除链表中等于给定值 val 的所有节点。

示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
*/

/*
解法：递归
执行用时：1 ms, 在所有 Java 提交中击败了99.67% 的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了22.68% 的用户
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}

/*
解法二：迭代
执行用时：1 ms, 在所有 Java 提交中击败了99.67% 的用户
内存消耗：39.3 MB, 在所有 Java 提交中击败了87.58% 的用户
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode flag = new ListNode(-1);
        flag.next = head;
        ListNode p = flag;
        while(p.next != null) {
            if(p.next.val == val)
                p.next = p.next.next;
            else p = p.next;
        }
        return flag.next;
    }
}

/*
解法三：迭代的另一种方式，设置前继和当前节点
执行用时：1 ms, 在所有 Java 提交中击败了99.67% 的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了80.83% 的用户
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode flag = new ListNode(-1);
        flag.next = head;
        ListNode p = flag, q = head;
        while(q != null) {
            if(q.val == val)
                p.next = q.next;
            else p = p.next;
            q = q.next;
        }
        return flag.next;
    }
}

