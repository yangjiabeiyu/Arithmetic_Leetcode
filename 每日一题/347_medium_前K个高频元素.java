/*
347. 前 K 个高频元素
https://leetcode-cn.com/problems/top-k-frequent-elements/
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]

提示：
    你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
    题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
    你可以按任意顺序返回答案。
*/

/*
解法：先对数组排序，然后统计各数字出现的次数，此处可以使用二维数组记录数字及其对应的次数；然后对次数排序，记录最大的k个数字
执行用时：12 ms, 在所有 Java 提交中击败了97.34% 的用户
内存消耗：41.8 MB, 在所有 Java 提交中击败了5.67% 的用户
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] arr = new int[nums.length][2];
        int index = -1;
        for(int num : nums) {
            if(index == -1 || arr[index][1] != num)
                arr[++index][1] = num;
            arr[index][0]++;
        }
        int[][] arr2 = Arrays.copyOf(arr, index + 1);
        Arrays.sort(arr2, (v1, v2) -> v1[0] - v2[0]);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = arr2[index - i][1];
        }
        return res;
    }
}

/*
解法二：先使map记录各数字出现的次数，然后创建大小为k的最小堆，遍历得到出现次数前k大的元素
执行用时：17 ms, 在所有 Java 提交中击败了53.25% 的用户
内存消耗：41.3 MB, 在所有 Java 提交中击败了56.68% 的用户
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);     // 统计次数
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (v1, v2) -> map.get(v1) - map.get(v2));    // 建立最小堆
        int cnt = 0;
        for(Integer num : map.keySet()) {        // 对于map的key，这里不能使用nums，因为会重复
            if(cnt < k)            // 这里也可以使用minHeap.size()和k作比较，可以省去cnt
                minHeap.offer(num);
            else if(map.get(num) > map.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.offer(num);
            }
            cnt++;
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
}

/*
解法二的其他实现方式
执行用时：17 ms, 在所有 Java 提交中击败了53.25% 的用户
内存消耗：41.1 MB, 在所有 Java 提交中击败了82.42% 的用户
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (v1, v2) -> map.get(v1) - map.get(v2));
        int cnt = 0;
        for(int num : map.keySet()) {    // 这里使用int也可以
            if(cnt < k)
                minHeap.offer(num);
            else if(map.get(num) > map.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.offer(num);
            }
            cnt++;
        }
        int[] res = new int[k];
        cnt = 0;
        for(int i : minHeap)   // 这里可以把minHeap当作迭代器
            res[cnt++] = i;
        return res;
    }
}

/*
解法三：桶排序，其实和解法一差不多；使用列表记录出现次数为i的元素有哪些，然后倒序遍历列表数组
执行用时：12 ms, 在所有 Java 提交中击败了97.34% 的用户
内存消耗：41 MB, 在所有 Java 提交中击败了91.06% 的用户
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] lists = new List[nums.length + 1];   // 列表数组，记录次数为i的元素
        for(int key : map.keySet()) {
            int val = map.get(key);  // 出现次数
            if(lists[val] == null)   // 初始化
                lists[val] = new ArrayList<>();
            lists[val].add(key);  // 添加
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = nums.length; i >= 0; i--) {  // 倒序找前k大
            if(lists[i] != null) {
                for(int j = 0; j < lists[i].size(); j++) {
                    res[index++] = lists[i].get(j);
                        if(index == k)
                            return res;
                }
            }
        }
        return res;
    }
}

/*
解法四：快排
*/


