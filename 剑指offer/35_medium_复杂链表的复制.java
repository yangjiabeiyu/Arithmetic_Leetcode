/*
剑指 Offer 35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：先依据next建立所有链表，在建立的过程中建立新老节点的映射关系，再遍历一遍得到random的连接关系
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.6 MB, 在所有 Java 提交中击败了99.98% 的用户
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
        if(head == null)
            return null;
        Node newHead = new Node(head.val);
        Node p = head, q = newHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, newHead);
        while(p.next != null) {     // 一次遍历，得到基本结构
            p = p.next;
            q.next = new Node(p.val);
            q = q.next;
            map.put(p, q);         // 保存映射关系
        }
        p = head;
        q = newHead;
        while(p != null) {
            q.random = map.get(p.random);      // 根据映射关系即可建立起来random的连接
            q = q.next;
            p = p.next;
        }
        return newHead;
    }
}

/*
解法二：建立新老节点的联系时，可以先将复制的节点放到原节点的后面，这样根据复制的random就是原random指向节点的下一个节点
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.5 MB, 在所有 Java 提交中击败了100.00% 的用户
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node p = head;
        while(p != null) {                 // 复制的节点放到被复制节点的后侧
            Node q = new Node(p.val);
            q.next = p.next;
            p.next = q;
            p = p.next.next;
        }
        p = head;
        while(p != null) {                 // 将random复制，注意random可能指向null，此时没有next
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        Node root = new Node(0);
        Node q = root;
        while(p != null) {                // 复原原链表，并将新链表提取出来
            q.next = p.next;
            p.next = p.next.next;
            q = q.next;
            p = p.next;
        }
        return root.next;
    }
}

