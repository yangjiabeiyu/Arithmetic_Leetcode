/*
合并K个升序链表
https://leetcode-cn.com/problems/merge-k-sorted-lists/
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
示例
输入：lists = [[1,4,5],[1,3,4],[2,6]]    输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
*/

/*
解法：逐个合并
执行用时：138 ms, 在所有 Java 提交中击败了17.57% 的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了93.16% 的用户
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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(int i = 0; i < lists.length; i++)
            res = mergeTwoLists(res, lists[i]);
        return res;
    }
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
