/*
1、hashmap转为entry数组
eg：可使用getKey与getValue取到值，当然也可以使用keySet来遍历，但如果只是需要value，就更加方便。
*/
for(Map.Entry<Integer, Integer> x : map.entrySet())
    if(!set.add(x.getValue()))
        return false;

/*
2、hashmap取值
*/
map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

/*
3、StringBuilder方法
*/
res.deleteCharAt(res.length() - 1);  // 删除指定位置元素
res.toString();                      // builder转字符串
res.length(); // 长度
res.reverse();  // 翻转

/*
4、类型转换
*/
char[] c = s.toCharArray();    // 字符串转char数组
String.valueOf(c);             // char数组转字符串
List <Integer> res = new ArrayList<>();
res.stream().mapToInt(Integer::intValue).toArray();  // Integer列表转int数组
char ch = (char) (num + '0');  // 整数转字符
int i = ch - '0'; // 字符转整数

/*
5、字符串拼接
*/
List<String> res = new ArrayList<>();
List<String> path = new ArrayList<>();
res.add(String.join(" ", path));  // 可以拼接字符串数组或队列

/*
6、ArrayList方法
*/
List<String> res = new ArrayList<>();
res.add(); // 末尾添加
res.remove(); // 删除末尾
res.set(index, value);  // 修改值
res.size();  // 列表的长度

/*
7、hashset方法
*/
set.contains(i);  // set是否包含i
set.add(i);           // 添加i
set.remove(i);   // 删除i

/*
8、数组剪切
*/
Arrays.copyOfRange(arr, 0, index);  // 得到arr数组的前index个数字

/*
9、优先队列
*/
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b - a);  // 最大堆
PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);  // 最小堆
maxHeap.add(num);    // 添加元素
maxHeap.peek();      // 查看堆顶元素
maxHeap.poll();      // 弹出堆顶元素
