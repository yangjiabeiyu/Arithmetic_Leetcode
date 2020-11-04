/*
138. 复制带随机指针的链表
https://leetcode-cn.com/problems/copy-list-with-random-pointer/
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的 深拷贝。 
我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
    val：一个表示 Node.val 的整数。
    random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
*/

/*
解法一：使用hashmap存储老新节点，这样可以通过老节点的random指向的节点，得到对应的新节点。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了75.15% 的用户
*/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node headB = new Node(head.val), p = head, q = headB;
        map.put(p, q);
        while(p.next != null) {
            p = p.next;
            q.next = new Node(p.val);
            map.put(p, q.next);            // 放入新老节点
            q = q.next;
        }
        p = head;
        q = headB;
        while(p != null) {
            q.random = map.get(p.random);   // 通过map得到对应的指向
            p = p.next;
            q = q.next;
        }
        return headB;
    }
}

/*
解法二：把新的节点放在后面，这样找random，直接next就是。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了90.81% 的用户
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        while(p != null) {     // 把复制的节点放到后面
            Node temp = p.next;
            p.next = new Node(p.val);
            p.next.next = temp;
            p = temp;
        }
        p = head;
        while(p != null) {
            p.next.random = p.random == null ? null : p.random.next;    // random的复制
            p = p.next.next;
        }
        p = head;
        Node flag = new Node(0), q = flag;
        while(p != null) {     // 拆分两链表
            q.next = p.next;
            q = q.next;
            p.next = q.next;
            p = p.next;
        }
        return flag.next;
    }
}


