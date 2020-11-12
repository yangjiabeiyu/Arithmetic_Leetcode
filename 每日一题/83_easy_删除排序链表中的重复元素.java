/*
83. 删除排序链表中的重复元素
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
输入: 1->1->2
输出: 1->2

示例 2:
输入: 1->1->2->3->3
输出: 1->2->3
*/

/*
解法一：递归，用set记录出现过的元素。
执行用时：1 ms, 在所有 Java 提交中击败了67.81% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了86.90% 的用户
*/
class Solution {
    Set<Integer> set = new HashSet<>();
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        head.next = deleteDuplicates(head.next);
        return set.add(head.val) ? head : head.next;
    }
}

/*
解法二：既然是排序的，就直接看下一个和当前是否一样即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了86.12% 的用户
*/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode p = head;
        while(p != null && p.next != null) {
            if(p.val == p.next.val) {
                ListNode q = p.next;
                p.next = q.next;
                q.next = null;
            }
            else
                p = p.next;
        }
        return head;
    }
}


