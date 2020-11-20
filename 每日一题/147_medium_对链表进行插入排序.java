/*
147. 对链表进行插入排序
https://leetcode-cn.com/problems/insertion-sort-list/
对链表进行插入排序。
插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

插入排序算法：
    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
    重复直到所有输入数据插入完为止。
*/

/*
解法一：每次将待处理的节点插入到已经有序的链表之中。
执行用时：26 ms, 在所有 Java 提交中击败了28.58% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了71.49% 的用户
*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode q = head.next;
        head.next = null;  // 先将已排序链表与剩余链表断开
        while(q != null) {
            ListNode temp = q.next;  // 先保存下来下一个待处理节点
            head = insert(head, q);   // 插入
            q = temp;  
        }
        return head;
    }
    public ListNode insert(ListNode head, ListNode node) {
        ListNode p = new ListNode(0);  // 设置哑节点
        p.next = head;
        ListNode pre = p, cur = p.next;
        while(cur != null && cur.val < node.val) {   // 寻找待插入位置
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;  // 插入
        node.next = cur;
        return p.next;  // 返回头结点
    }
}

/*
解法二：记录已排序尾节点与新节点，如果新节点值更大，就直接后移更新；如果新节点值小，就先把尾节点的next接到新节点的next，然后从前往后找到插入位置。
执行用时：6 ms, 在所有 Java 提交中击败了47.73% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了90.61% 的用户
*/
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0), pre = head, cur = head.next;
        dummyHead.next = head;  // 设置哑节点
        while(cur != null) {
            if(cur.val >= pre.val)  // 如果当前节点较大，就直接作为已排序链表的尾节点
                pre = cur;
            else {
                pre.next = cur.next;       // 先记录一下下一个待插入节点
                ListNode p = dummyHead;
                while(p.next.val < cur.val)
                    p = p.next;        // 确定插入位置
                cur.next = p.next;     // 插入
                p.next = cur;
            }
            cur = pre.next;   // 更新下一个待插入节点
        }
        return dummyHead.next;
    }
}

