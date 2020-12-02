/*
142. 环形链表 II
https://leetcode-cn.com/problems/linked-list-cycle-ii/
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
说明：不允许修改给定的链表。

进阶：
    你是否可以使用 O(1) 空间解决此题？
*/

/*
判圈法
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了76.73% 的用户
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        // 注意，这里fast和slow必须在同一位置开走，因为推导中都是按从head开走的；如果一个是head，一个是head.next，那么之后fast回到head，两者不会在交点处相遇。
        ListNode slow = head.next, fast = head.next.next;   
        while(slow != fast) {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

