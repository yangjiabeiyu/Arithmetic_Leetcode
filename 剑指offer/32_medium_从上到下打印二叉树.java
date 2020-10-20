/*
剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回：

[3,9,20,15,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
迭代
执行用时：1 ms, 在所有 Java 提交中击败了99.77% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了98.69% 的用户
*/
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            list.add(p.val);
            if(p.left != null)
                queue.offer(p.left);
            if(p.right != null)
                queue.offer(p.right);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}

