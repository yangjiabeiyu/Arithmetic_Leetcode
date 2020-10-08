/*
相交链表
https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
题目描述
编写一个程序，找到两个单链表相交的起始节点。
注意事项
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
*/

/*
解法一：先遍历两个链表，得到长度差delta，然后较长的链表先走delta步，然后一起往前走，直到找到交点
执行用时：1 ms, 在所有 Java 提交中击败了99.99% 的用户
内存消耗：41.5 MB, 在所有 Java 提交中击败了76.33% 的用户
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int num1 = 0, num2 = 0;
        ListNode h1 = headA, h2 = headB;
        // 得到链表长度
        while(h1 != null) {
            num1++;
            h1 = h1.next;
        }
        while(h2 != null) {
            num2++;
            h2 = h2.next;
        }
        h1 = headA;
        h2 = headB;
        if(num1 > num2)
            for(int i = 0; i < num1 - num2; i++)
                h1 = h1.next;
        else
            for(int i = 0; i < num2 - num1; i++)
                h2 = h2.next;
        // 准备就绪
        while(true) {
            if(h1 == h2)
                return h1;
            h1 = h1.next;
            h2 = h2.next;
        }
    }
}

/*
解法二：对于A和B两个链表，一起向前走，A走到null后再从B开始走；B走到null后再从A开始走，那么一定会一起走到交点
执行用时：1 ms, 在所有 Java 提交中击败了99.99% 的用户
内存消耗：41.7 MB, 在所有 Java 提交中击败了45.07% 的用户
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while(h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}
