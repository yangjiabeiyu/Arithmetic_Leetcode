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

/*
4、类型转换
*/
char[] c = s.toCharArray();    // 字符串转char数组
String.valueOf(c);             // char数组转字符串

