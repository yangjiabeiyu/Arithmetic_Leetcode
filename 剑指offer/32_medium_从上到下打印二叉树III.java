/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：使用双端队列deque来存储节点，对于奇数层，从队头拿出元素，然后将左右孩子从队尾压入；对于偶数层，从队尾拿出元素，然后将右左孩子从队头压入。保持存储每层val的list的单调性(尾插)
执行用时：1 ms, 在所有 Java 提交中击败了99.84% 的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了100.00% 的用户
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        deque.offerLast(root);
        boolean direction = true;         // 判断奇偶层，当然也可以通过lists的size来判断
        while(!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();      // 尾插
            if(direction) {              // 奇数层
                for(int i = 0; i < size; i++) {
                    TreeNode p = deque.pollFirst();
                    list.add(p.val);
                    if(p.left != null)
                        deque.offerLast(p.left);
                    if(p.right != null)
                        deque.offerLast(p.right);
                }
            }
            else {                      // 偶数层
                for(int i = 0; i < size; i++) {
                    TreeNode p = deque.pollLast();
                    list.add(p.val);
                    if(p.right != null)
                        deque.offerFirst(p.right);
                    if(p.left != null)
                        deque.offerFirst(p.left);
                }
            }
            lists.add(list);
            direction = !direction; 
        }
        return lists;
    }
}


/*
解法二：可以保持保存节点的queue的单调性，让存储val的list成为双向的。如果是奇数层，就把val从尾部插入；偶数层则从头部插入，每个节点的左右孩子依然是尾插放到queue中。
执行用时：1 ms, 在所有 Java 提交中击败了99.84% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了99.28% 的用户
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();   // 用LinkedList作为双端队列
            for(int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if(lists.size() % 2 == 0)             // 奇数层
                    list.offerLast(p.val);
                else
                    list.offerFirst(p.val);
                if(p.left != null)
                    queue.offer(p.left);
                if(p.right != null)
                    queue.offer(p.right);
            }
            lists.add(list);
        }
        return lists;
    }
}

