/*
删除链表的倒数第N个节点
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
题目描述
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：给定的 n 保证是有效的。
*/

/*
解法：维护一个快慢指针，间隔为n即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了99.79% 的用户
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode flag = new ListNode();   // 创建一个哑节点，可有效处理删除头结点的情形
        flag.next = head;
        ListNode p = flag, q = flag; 
        int i = 0;
        while(p != null && i < n) {   // 这里i<=n更好，如此的话快慢节点间隔n个节点，这样后续循环到p = null，慢指针就指向倒数第n+1个节点
            p = p.next;
            i++;
        }
        while(p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return flag.next;
    }
}
