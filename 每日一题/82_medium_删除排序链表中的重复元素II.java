/*
82. 删除排序链表中的重复元素 II
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:
输入: 1->1->1->2->3
输出: 2->3
*/

/*
执行用时：1 ms, 在所有 Java 提交中击败了66.80% 的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了88.62% 的用户
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while(p.next != null && p.next.next != null) {
            if(p.next.val == p.next.next.val) {
                ListNode q = p.next.next.next;
                int value = p.next.val;
                while(q != null && q.val == value)  // 要一直找到不重复的节点，然后接上
                    q = q.next;
                p.next = q;
            }
            else p = p.next;
        }
        return dummyHead.next;
    }
}

