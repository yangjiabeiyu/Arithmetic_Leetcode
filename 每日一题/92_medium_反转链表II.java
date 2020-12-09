/*
92. 反转链表 II
https://leetcode-cn.com/problems/reverse-linked-list-ii/
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
*/

/*
解法一：迭代，找到两个端点
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.1 MB, 在所有 Java 提交中击败了64.73% 的用户
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead, q = dummyHead;
        for(int i = 1; i < m; i++)   // 找到m的前继
            p = p.next;
        for(int i = 0; i < n; i++)   // 找到n
            q = q.next;
        ListNode cur = p.next, pre = q.next;   // pre是n的后续
        p.next = q;   // m的前继的后继应该是n处的q
        while(cur != q) {
            ListNode temp = cur.next;   // 正常的反转
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        q.next = pre; // 把q的后继连上pre
        return dummyHead.next;   // 返回dummyHead的后继即可
    }
}

/*
迭代的另一种写法，相当于逐个反转
1->2->3->4->5->6  m = 2, n = 5
1->3->2->4->5->6
1->4->3->2->5->6
1->5->4->3->2->
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36 MB, 在所有 Java 提交中击败了74.81% 的用户
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead, q = dummyHead;
        for(int i = 1; i < m; i++)
            p = p.next;    // 先找到m的前继p
        ListNode cur = p.next;  // 待翻转的节点
        for(int i = m; i < n; i++) {
            ListNode temp = cur.next;   // 先记录一下后继
            cur.next = temp.next;   // 当前反转后，cur后继是temp的后继
            temp.next = p.next;     // temp的后继给到p的next
            p.next = temp;          // p的next更新为temp
        }
        return dummyHead.next;
    }
}

