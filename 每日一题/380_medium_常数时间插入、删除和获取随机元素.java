/*
380. 常数时间插入、删除和获取随机元素
https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。

insert(val)：当元素 val 不存在时，向集合中插入该项。
remove(val)：元素 val 存在时，从集合中移除该项。
getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
示例 :
// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();
// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);
// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);
// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);
// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();
// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);
// 2 已在集合中，所以返回 false 。
randomSet.insert(2);
// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();
*/

/*
解法：插入可以使用动态数组，ArrayList，同时使用map来确定是否有重复元素；随机返回可以使用random来得到随机位置，然后get相应位置的元素；
删除则需要定位到具体的索引，所以可以使用map建立val和index的映射；定位后，将最后一个元素移到索引处，然后把最后一个元素删除即可。
执行用时：12 ms, 在所有 Java 提交中击败了80.24%的用户
内存消耗：43.4 MB, 在所有 Java 提交中击败了56.71%的用户
*/
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val), lastVal = list.get(list.size() - 1);  // 注意这里需要考虑val就是最后一个元素的情况
            map.put(lastVal, index);  // 这里只能先put，再remove；否则如果val=lastval，先remove再put，就没有remove的效果了。
            map.remove(val);
            list.set(index, lastVal);  // 同样也是先set再remove
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

