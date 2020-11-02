/*
350. 两个数组的交集 II

给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

说明：
    输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
    我们可以不考虑输出结果的顺序。

进阶：
    如果给定的数组已经排好序呢？你将如何优化你的算法？
    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
    如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
*/

/*
解法一：哈希表，进阶问题二的答案
执行用时：4 ms, 在所有 Java 提交中击败了56.73% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了78.71% 的用户
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);  // 计数
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {  / /如果存在而且多于0个，就加入结果之中
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] rest = new int[res.size()];
        for(int i = 0; i < res.size(); i++)   // 列表转数组
            rest[i] = res.get(i);
        return rest;
    }
}

/*
解法二：先排序再得到答案，进阶问题一的答案
执行用时：3 ms, 在所有 Java 提交中击败了85.06% 的用户
内存消耗：39 MB, 在所有 Java 提交中击败了47.72% 的用户
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] == nums2[index2]) {
                res.add(nums1[index1]);
                index1++;
                index2++;
            }
            else if(nums1[index1] > nums2[index2])
                index2++;
            else
                index1++;
        }
        int[] rest = new int[res.size()];
        for(int i = 0; i < res.size(); i++)   // 列表转数组
            rest[i] = res.get(i);
        return rest;
    }
}

/*
对应进阶问题三，如果内存十分小，不足以将数组全部载入内存，那么必然也不能使用哈希这类费空间的算法，只能选用空间复杂度最小的算法，即解法一。
但是解法一中需要改造，一般说排序算法都是针对于内部排序，一旦涉及到跟磁盘打交道（外部排序），则需要特殊的考虑。
归并排序是天然适合外部排序的算法，可以将分割后的子数组写到单个文件中，归并时将小文件合并为更大的文件。
当两个数组均排序完成生成两个大文件后，即可使用双指针遍历两个文件，如此可以使空间复杂度最低。
作者：Alien-Leon
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/jin-jie-san-wen-by-user5707f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

