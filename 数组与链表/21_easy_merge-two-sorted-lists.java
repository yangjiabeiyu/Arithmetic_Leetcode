/*
合并两个有序链表
https://leetcode-cn.com/problems/merge-two-sorted-lists/
题目描述
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
解法一：迭代，不断比较得到新的链表
执行用时：1 ms, 在所有 Java 提交中击败了62.79% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了19.54% 的用户
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode();
        ListNode head = resNode;
        while(true) {
            if(l1 == null || l2 == null) {
                resNode.next = l1 == null ? l2 : l1;
                return head.next;
            }
            else {
                if(l1.val <= l2.val) {
                    resNode.next = l1;
                    l1 = l1.next;
                }
                else {
                    resNode.next = l2;
                    l2 = l2.next;        
                }
                resNode = resNode.next;
            }
        }
    }
}

/*
解法二：递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了10.26% 的用户
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        else {
            if(l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
            else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
