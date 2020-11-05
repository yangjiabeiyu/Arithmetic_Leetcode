/*
116. 填充每个节点的下一个右侧节点指针
https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
*/

/*
解法：层序遍历
执行用时：3 ms, 在所有 Java 提交中击败了43.13% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了31.30% 的用户
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        Node p = root;
        queue.offer(p);
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                Node q = queue.poll();
                if(i > 1) q.next = queue.peek();
                if(q.left != null) queue.offer(q.left);
                if(q.right != null) queue.offer(q.right);
            }
        }
        return root;
    }
}

