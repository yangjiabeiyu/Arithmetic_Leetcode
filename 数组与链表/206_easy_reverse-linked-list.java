/*
反转链表
https://leetcode-cn.com/problems/reverse-linked-list/
题目描述
反转一个单链表。
示例
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
*/

/*
递归
执行用时：22 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了5.12% 的用户
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;  // 记录
        while(temp.next.next != null)  // 找到倒数第二个节点
            temp = temp.next;
        ListNode node = temp.next;  // 保存最后的节点
        temp.next = null;
        node.next = reverseList(head);  // 反转前n-1个节点
        return node;
    }
}


/*
递归二：找到最后的节点再反转比较麻烦，可以从头反转，将头结点和后面反转好的节点进行反转即可
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了36.70% 的用户
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);  // 将后续链表反转
        head.next.next = head;  // head的next变成了后面的尾节点，它的后面应该是head
        head.next = null; // 避免成环
        return p;
    }
}

/*
迭代
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了52.11% 的用户
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head, prev = null;
        while(cur != null) {
            ListNode p = cur.next;  // 先记录下当前节点的后继
            cur.next = prev;  // 当前节点的后继变为上一节点
            prev = cur;  // 迭代
            cur = p; // 迭代
        }
        return prev;
    }
}
